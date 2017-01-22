class SmokeSensor(location: String) extends Sensor {
  private val sensorType: String = "Smoke"
  private var batteryPercentage: Double = 100.0

  override def isTriggered: Boolean = false

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = -1
}
