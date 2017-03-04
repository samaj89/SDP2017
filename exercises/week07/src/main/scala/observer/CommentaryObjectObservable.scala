package observer

import scala.collection.mutable.ListBuffer

class CommentaryObjectObservable(val title: String) extends Subject with Commentary {
  var subscribers: ListBuffer[Observer] = new ListBuffer[Observer]()
  var latest: String = "Nothing to report"

  override def subscribeObserver(observer: Observer) = subscribers append observer

  override def unSubscribeObserver(observer: Observer) = {
    val indexToRemove = subscribers indexOf observer
    if (indexToRemove != -1) subscribers remove indexToRemove
  }

  override def notifyObservers() = {
    for (observer <- subscribers) {
      observer.update(subjectDetails)
    }
  }

  override def subjectDetails: String = title + ": " + latest

  override def setDesc(desc: String) = {
    latest = desc
    notifyObservers()
  }
}
