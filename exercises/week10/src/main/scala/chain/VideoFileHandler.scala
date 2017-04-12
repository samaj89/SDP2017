package chain

case class VideoFileHandler(s: String) extends Handler {
  var next: Handler = null

  override def setHandler(handler: Handler): Unit = {
    next = handler
  }

  override def process(file: File): Unit = {
    if (file.fileType equals "video") println("Process and saving video file... by " + getHandlerName)
    else if (next != null) {
      println(getHandlerName + " forwards request to " + next.getHandlerName)
      next.process(file)
    }
    else println("File not supported")
  }

  override def getHandlerName(): String = s
}
