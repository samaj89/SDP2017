import scala.util.Random

class SmokeSensor(location: String) extends Sensor {
  private val sensorType: String = "Smoke"
  private var batteryPercentage: Double = 100.0

  override def isTriggered: Boolean = {
    if (getBatteryPercentage != 0) batteryPercentage -= 20
    Random.nextDouble() < 0.1
  }

  override def getLocation: String = location

  override def getSensorType: String = sensorType

  override def getBatteryPercentage: Double = batteryPercentage
}
