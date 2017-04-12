package chain

case class AudioFileHandler(s: String) extends Handler {
  var next: Handler = null

  override def setHandler(handler: Handler): Unit = {
    next = handler
  }

  override def process(file: File): Unit = {
    if (file.fileType equals "audio") println("Process and saving audio file... by " + getHandlerName)
    else if (next != null) {
      println(getHandlerName + " forwards request to " + next.getHandlerName)
      next.process(file)
    }
    else println("File not supported")
  }

  override def getHandlerName(): String = s
}
