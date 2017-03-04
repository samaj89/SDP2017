package observer

class SMSUsersObserver (s: Subject, msg: String) extends Observer {
  var latest: String = "Nothing to report"

  override def update(desc: String) = {
    latest = desc
    printUpdate
  }

  override def subscribe() = s.subscribeObserver(this)

  override def unSubscribe() = s.unSubscribeObserver(this)

  def printUpdate = {
    println(msg)
    println(latest)
  }
}
