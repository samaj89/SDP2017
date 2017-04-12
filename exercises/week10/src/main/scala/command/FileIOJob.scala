package command

class FileIOJob extends Job {
  var thisFileIO: FileIO = null

  def setFileIO(fileIO: FileIO): Unit = {
    thisFileIO = fileIO
  }

  override def run(): Unit = thisFileIO.execute()
}