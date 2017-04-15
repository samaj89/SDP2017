package memento

case class Originator(
  var x: Double,
  var y: Double,
  var careTaker: CareTaker
) {

  private var lastUndoSavepoint: String = _

  createSavepoint("INITIAL")

  def createSavepoint(savepointName: String): Unit = {
    println("Saving state..." + savepointName)
    val newSave = Memento(x, y)
    careTaker.saveMemento(newSave, savepointName)
    lastUndoSavepoint = savepointName
  }

  def undo(): Unit = {
    println("Undo at ..." + lastUndoSavepoint)
    val restorePoint = careTaker.getMemento(lastUndoSavepoint)
    x = restorePoint.x
    y = restorePoint.y
  }

  def undo(savepointName: String): Unit = {
    println("Undo at ..." + savepointName)
    val restorePoint = careTaker.getMemento(savepointName)
    x = restorePoint.x
    y = restorePoint.y
  }

  def undoAll(): Unit = {
    println("Undo at ...INITIAL")
    val restorePoint = careTaker.getMemento("INITIAL")
    careTaker.clearSavepoints()
    x = restorePoint.x
    y = restorePoint.y
  }

  private def setOriginatorState(savepointName: String): Unit = undo(savepointName)

  override def toString(): String = "X: " + x + ", Y: " + y
}
