import java.time.LocalDateTime

/**
  * Created by samaj on 22/01/17.
  */
object SecurityControlUnit

class SecurityControlUnit(sensors: List[SecuritySensor]) extends ControlUnit(sensors) {
  def timeCheck: Boolean = {
    val hour: Int = LocalDateTime.now().getHour
    hour > 21 || hour < 6
  }

  override def pollSensors() {
    if (timeCheck) super.pollSensors() else println("Can only poll between 2200 and 0600.")
  }
}
