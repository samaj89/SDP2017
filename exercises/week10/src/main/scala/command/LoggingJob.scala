package command

class LoggingJob extends Job {
  var thisLogging: Logging = null

  def setLogging(logging: Logging): Unit = {
    thisLogging = logging
  }

  override def run(): Unit = thisLogging.log
}