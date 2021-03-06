package com.arcusys.valamis.persistence.impl.scorm.storage

import java.sql.Connection

import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.valamis.lesson.scorm.storage.sequencing.{ChildrenSelectionStorage, SequencingPermissionsStorage, _}
import com.arcusys.valamis.persistence.common.SlickProfile
import com.arcusys.valamis.persistence.impl.scorm.schema._
import com.arcusys.valamis.slick.util.SlickDbTestBase
import org.scalatest.{BeforeAndAfter, FunSuite}

/**
  * Created by eboystova on 10.05.16.
  */
class SequencingTrackingStorageTest extends FunSuite
  with ChildrenSelectionTableComponent
  with ConditionRuleTableComponent
  with SequencingTableComponent
  with SeqPermissionsTableComponent
  with SequencingTrackingTableComponent
  with ObjectiveTableComponent
  with ObjectiveMapTableComponent
  with RollupContributionTableComponent
  with RollupRuleTableComponent
  with SlickProfile
  with BeforeAndAfter
  with SlickDbTestBase {

  val storages = new StorageFactory(db, driver)

  val sequencingTrackingStorage = storages.getSequencingTrackingStorage
  val sequencingStorage = storages.getSequencingStorage

  before {
    createDB()
    createSchema()
  }
  after {
    dropDB()
  }

  def createSchema() {
    import driver.simple._
    db.withSession { implicit session =>
      sequencingTQ.ddl.create
      seqPermissionsTQ.ddl.create
      rollupContributionTQ.ddl.create
      objectiveTQ.ddl.create
      objectiveMapTQ.ddl.create
      childrenSelectionTQ.ddl.create
      sequencingTrackingTQ.ddl.create
      conditionRuleTQ.ddl.create
      rollupRuleTQ.ddl.create
    }
  }


  test("execute 'get' without errors") {
    sequencingStorage.create(123, "456", Sequencing.Default)
    import driver.simple._
    db.withSession { implicit session =>
      val seq = sequencingTQ.filter(a => a.activityId === "456" && a.packageId === 123L).firstOption
      assert(seq.isDefined)

      val seqTracking = sequencingTrackingStorage.get(seq.get.id.get)
      assert(seqTracking.isDefined)
    }
  }

}
