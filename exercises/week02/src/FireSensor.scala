import scala.util.Random

class FireSensor(location: String) extends HazardSensor with BatteryPowered {
  private val sensorType: String = "Fire"
  private var batteryPercentage: Double = 100.0

  override def isTriggered: Boolean = {
    if (getBatteryPercentage != 0) batteryPercentage -= 10
    Random.nextDouble() < 0.05
  }

  override def getLocation: String = location

  override def getSensorType: String = sensorType

  override def getBatteryPercentage: Double = batteryPercentage
}
