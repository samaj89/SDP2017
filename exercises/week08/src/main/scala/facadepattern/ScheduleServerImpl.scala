package facadepattern

case class ScheduleServerImpl() extends ScheduleServer {
  override def startBooting = println("Booting up...")

  override def readSystemConfigFile = println("Reading system configuration file...")

  override def init = println("Initializing...")

  override def initializeContext = println("Initializing context...")

  override def initializeListeners = println("Initializing listeners...")

  override def createSystemObjects = println("Creating system objects")

  override def releaseProcesses = println("Releasing processes...")

  override def destory = println("Destroying...")

  override def destroySystemObjects = println("Destroying system objects...")

  override def destoryListeners = println("Destroying listeners...")

  override def destoryContext = println("Destroying context...")

  override def shutdown = println("Shutting down...")
}
