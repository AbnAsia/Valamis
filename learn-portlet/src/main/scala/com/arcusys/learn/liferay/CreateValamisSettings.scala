package com.arcusys.learn.liferay

import javax.portlet.PortletPreferences

import com.liferay.portal.kernel.events.SimpleAction
import com.liferay.portal.kernel.util.PrefsPropsUtil

/**
 * Created by nvorobyova on 28.08.15.
 */
class CreateValamisSettings extends SimpleAction {

  override def run(companyIds: Array[String]): Unit = {
    companyIds.foreach(companyId => {
      SetValamisEmailTemplates(companyId)
    })
  }

  private def SetValamisEmailTemplates(companyId: String) {
    val valamisStudentEnrolledSubject: String = "VALAMIS_EMAIL_STUDENT_ENROLLED_SUBJECT"
    val valamisStudentEnrolledBody: String = "VALAMIS_EMAIL_STUDENT_ENROLLED_BODY"

    val valamisCompleteModuleSubject: String = "VALAMIS_EMAIL_COMPLETE_MODULE_SUBJECT"
    val valamisCompleteModuleBody: String = "VALAMIS_EMAIL_COMPLETE_MODULE_BODY"

    val valamisCertificateDeadlineSubject: String = "VALAMIS_EMAIL_CERTIFICATE_DEADLINE_SUBJECT"
    val valamisCertificateDeadlineBody: String = "VALAMIS_EMAIL_CERTIFICATE_DEADLINE_BODY"

    val valamisCertificateExpireSubject: String = "VALAMIS_EMAIL_CERTIFICATE_EXPIRE_SUBJECT"
    val valamisCertificateExpireBody: String = "VALAMIS_EMAIL_CERTIFICATE_EXPIRE_BODY"

    val header = "<h2 style=\"background-color: #A7C46C; color: #fff; padding-top: 10px;" +
      "padding-bottom: 10px; padding-left: 10px; margin: 0; font-family: Times New Roman, serif; margin-bottom: 5px;\">"
    val body = "</h2><div style=\"font-family: Helvetica,sans-serif; padding-left: 10px; font-weight: bold; font-size: 1.3em;\">" +
      "[$DATE$]</div><h4 style=\"font-family: Helvetica,sans-serif; padding-left:10px; margin-bottom: 3px;\">"
    val footer = "<div style=\"font-family: Helvetica,sans-serif; padding-left: 15px; border-top:1px solid #eee; padding-top: 10px\">"

    val preferences = PrefsPropsUtil.getPreferences(companyId.toLong)
    setValueIfEmpty(preferences,valamisStudentEnrolledSubject, "Valamis notification: enrolled students")
    setValueIfEmpty(preferences,
      valamisStudentEnrolledBody,
      header + "Valamis Course Notifications" + body + "Information about your courses.</h4>" +
          "[$REPEAT$]" + footer +
          "In course [$COURSE_NAME$] there are new students enrolled: [$ENROLLED_STUDENTS$]</div>" +
          "[$REPEAT$]")
    setValueIfEmpty(preferences,valamisCompleteModuleSubject, "Valamis notification: complete modules")
    setValueIfEmpty(preferences,
      valamisCompleteModuleBody,
      header + "Valamis Course Notifications" + body + "Information about your students.</h4>" +
          "[$REPEAT$]" + footer +
          "Student [$STUDENT_NAME$] finished modules: [$FINISHED_PACKAGES$]</div>" +
          "[$REPEAT$]")
    setValueIfEmpty(preferences,valamisCertificateDeadlineSubject, "Valamis notification: certificate goals deadline")
    setValueIfEmpty(preferences,
      valamisCertificateDeadlineBody,
      header + "Valamis Certificate Notifications" + body + "Information about your certificates.</h4>" +
          "[$REPEAT$]" +

          "<div style=\"font-family: Helvetica,sans-serif; padding-left: 15px; border-top:1px solid #eee; padding-top: 10px\">[$CERTIFICATE_NAME$] certificate goals have deadlines:</div>" +

          "<div style=\"font-family: Helvetica,sans-serif; padding-left: 15px; padding-top: 10px\">[$REPEAT_COURSE$]Course [$TITLE$] has deadline in [$DAYS$], at [$DATE$][$REPEAT_COURSE$]</div>" +

          "<div style=\"font-family: Helvetica,sans-serif; padding-left: 15px; padding-top: 10px\">[$REPEAT_STATEMENT$]Statement [$TITLE$] has deadline in [$DAYS$], at [$DATE$][$REPEAT_STATEMENT$]</div>" +

          "<div style=\"font-family: Helvetica,sans-serif; padding-left: 15px; padding-top: 10px\">[$REPEAT_ACTIVITY$]Activity [$TITLE$] has deadline in [$DAYS$], at [$DATE$][$REPEAT_ACTIVITY$]</div>" +
          "[$REPEAT$]")
    setValueIfEmpty(preferences,valamisCertificateExpireSubject, "Valamis notification: certificate expiration")
    setValueIfEmpty(preferences,
      valamisCertificateExpireBody,
      header + "Valamis Certificate Notifications" + body + "Information about your certificates.</h4>" +
        "[$REPEAT$]" + footer +
        "Certificate [$CERTIFICATE_NAME$] is going to expire in [$DAYS$] days, at [$DATE$] </div>" +
        "[$/REPEAT$]")
    preferences.store()
  }

  private def setValueIfEmpty(preferences: PortletPreferences, key: String, value :String): Unit = {
    if ("".equals(preferences.getValue(key, "")))
      preferences.setValue(key, value)
  }
}