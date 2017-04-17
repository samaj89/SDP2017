package state

case class RoboticOff(r: Robot) extends RoboticState {
  def walk(): Unit = {
    r.state = r.roboticOn
    r.walk
  }
  def cook(): Unit = println("Cannot cook at Off state")
  def off(): Unit = {
    r.state = r.roboticOff
  }
}
