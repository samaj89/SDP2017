package proxy.protectedproxy

class ReportGeneratorImpl extends ReportGenerator {

  override def generateDailyReport(): String = {
    var sb: StringBuilder = new StringBuilder
    sb.append("********************Location X Daily Report********************")
    sb.append("\n Location ID: 012")
    sb.append("\n Today’s Date: Sun Sep 39 00:11:23 GMT 2016")
    sb.append("\n Total Pizza Sell: 112")
    sb.append("\n Total Sale: $2534")
    sb.append("\n Net Profit: $1985")
    sb.append("\n***************************************************************")

    sb.toString
  }

}
