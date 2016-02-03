package com.arcusys.learn.models.response.certificates

import com.arcusys.learn.models.CourseResponse

case class CertificateShortResponse(
  id: Long,
  title: String,
  shortDescription: String,
  description: String,
  logo: String,
  isPublished: Boolean,
  courseCount: Int,
  statementCount: Int,
  activityCount: Int,
  packageCount: Int,
  userCount: Int,
  scope: Option[CourseResponse]) extends CertificateResponseContract
