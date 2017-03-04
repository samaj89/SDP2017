package observer

// Using SMSUsersObserver instead as per TestObserver

class SMSUsers(s: Subject, msg: String) extends Observer {
  def update(desc: String) = ???

  def subscribe() = ???

  def unSubscribe() = ???
}
