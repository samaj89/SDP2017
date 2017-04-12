package chain

case class DocFileHandler(s: String) extends Handler {
  var next: Handler = null

  override def setHandler(handler: Handler): Unit = {
    next = handler
  }

  override def process(file: File): Unit = {
    if (file.fileType equals "doc") println("Process and saving doc file... by " + getHandlerName)
    else if (next != null) {
      println(getHandlerName + " forwards request to " + next.getHandlerName)
      next.process(file)
    }
    else println("File not supported")
  }

  override def getHandlerName(): String = s
}
