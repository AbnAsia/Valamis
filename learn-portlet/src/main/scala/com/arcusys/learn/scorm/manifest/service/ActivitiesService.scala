package com.arcusys.learn.scorm.manifest.service

import com.arcusys.learn.controllers.api.base.BaseApiController
import com.arcusys.learn.liferay.permission.PermissionUtil._
import com.arcusys.learn.web.ServletBase
import com.arcusys.valamis.lesson.scorm.model.manifest.{Activity, LeafActivity}
import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateNode
import com.arcusys.valamis.lesson.service.ActivityServiceContract
import com.arcusys.valamis.util.TreeNode

class ActivitiesService extends BaseApiController with ServletBase {

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  lazy val activityManager = inject[ActivityServiceContract]

  val jsonModel = new JsonModelBuilder[Activity](activity =>
    Map(
      "id" -> activity.id,
      "title" -> activity.title,
      "visible" -> activity.visible,
      "childActivities" -> Nil,
      "leafData" -> (activity match {
        case leaf: LeafActivity => Map("resourceID" -> leaf.resourceIdentifier, "resourceParam" -> leaf.resourceParameters.getOrElse(""))
        case _                  => Map()
      })
    )
  )

  val jsonNodeModel = new JsonModelBuilder[TreeNode[Activity]](node => {

    def mapNode(node: TreeNode[Activity]): Map[String, Any] = Map(
      "id" -> node.item.id,
      "title" -> node.item.title,
      "visible" -> node.item.visible,
      "childActivities" -> node.children.map(mapNode),
      "leafData" -> (node.item match {
        case leaf: LeafActivity => Map("resourceID" -> leaf.resourceIdentifier, "resourceParam" -> leaf.resourceParameters.getOrElse(""))
        case _                  => Map()
      })
    )

    mapNode(node)
  })

  val jsonStateNodeModel = new JsonModelBuilder[ActivityStateNode](node => {

    def mapNode(node: ActivityStateNode): Map[String, Any] = Map(
      "id" -> node.item.activity.id,
      "title" -> node.item.activity.title,
      "visible" -> node.item.activity.visible,
      "childActivities" -> node.availableChildren.map(mapNode),
      "leafData" -> (node.item.activity match {
        case leaf: LeafActivity => Map("resourceID" -> leaf.resourceIdentifier, "resourceParam" -> leaf.resourceParameters.getOrElse(""))
        case _                  => Map()
      })
    )

    mapNode(node)
  })

  get("/manifestactivities(/)") {
    val userID = getUserId.toInt

    val packageID = parameter("packageID").intRequired
    val organizationID = parameter("organizationID").required

    val currentAttempt = activityManager.getActiveAttempt(userID, packageID, organizationID)
    val tree = activityManager.getActivityStateTreeForAttemptOrCreate(currentAttempt)

    jsonStateNodeModel(tree.availableChildren)
  }

  /* get("/manifestactivities/package/:packageID/organization/:organizationID/activity/:id") {
    val packageID = parameter("packageID").intRequired
    val id = parameter("id").required
    jsonModel(activityStorage.get(packageID, id))
  }*/
}