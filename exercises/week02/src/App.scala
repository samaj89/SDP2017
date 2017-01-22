import java.io.IOException
import java.util.Scanner

object App {
  private val EXIT: String = "exit"
  private val POLL: String = "poll"

  @throws[IOException]
  def main(args: Array[String]) {
//    val sensors: List[Sensor] = List(new FireSensor("1st floor lobby"), new SmokeSensor("In the auditorium"))
//    val controlUnit: ControlUnit = new ControlUnit(sensors)
    val sensors: List[SecuritySensor] = List(new MotionSensor("In the auditorium"))
    val controlUnit: SecurityControlUnit = new SecurityControlUnit(sensors)
    val scanner: Scanner = new Scanner(System.in)
    var input: String = ""
    while (input != EXIT) {
      println("Type \"poll\" to poll all sensors once or \"exit\" to exit")
      input = scanner.nextLine
      if (input == POLL) {
        controlUnit.pollSensors()
      }
    }
  }
}
