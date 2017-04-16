package proxy.remoteproxy

import java.rmi.Naming
import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject
import java.util.Date

object ReportGeneratorImpl extends App {
  try {
    val reportGenerator: ReportGenerator = new ReportGeneratorImpl()
    Naming.rebind("PizzaCoRemoteGenerator", reportGenerator)
  } catch {
    case e: Exception => e.printStackTrace()
  }
}

class ReportGeneratorImpl protected ()
  extends UnicastRemoteObject
  with ReportGenerator {

  @throws(classOf[RemoteException])
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
