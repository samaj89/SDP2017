/**
  * Created by samaj on 22/01/17.
  */

import scala.util.Random

class MotionSensor(location: String) extends SecuritySensor {
  private val sensorType: String = "Motion"

  override def isTriggered: Boolean = Random.nextDouble() < 0.1

  override def getLocation: String = location

  override def getSensorType: String = sensorType

}
