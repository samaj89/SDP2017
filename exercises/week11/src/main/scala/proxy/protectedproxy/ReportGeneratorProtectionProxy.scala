package proxy.protectedproxy

class ReportGeneratorProtectionProxy(var staff: Staff)
  extends ReportGeneratorProxy {

  var reportGenerator: ReportGenerator = _

  override def generateDailyReport(): String = {
    if (staff.isOwner) {
      reportGenerator = new ReportGeneratorImpl
      reportGenerator.generateDailyReport
    } else {
      "Not Authorized to view report."
    }
  }
}
