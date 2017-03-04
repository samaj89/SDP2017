package observer

// Using CommentaryObjectObservable instead as per TestObserver

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject {
  def subscribeObserver(observer: Observer) = ???

  def unSubscribeObserver(observer: Observer) = ???

  def notifyObservers() = ???

  def subjectDetails: String = ???
}
