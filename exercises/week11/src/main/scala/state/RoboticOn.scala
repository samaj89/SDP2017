package state

case class RoboticOn(r: Robot) extends RoboticState {
  def walk(): Unit = println("Walking...")
  def cook(): Unit = {
    r.state = r.roboticCook
    r.cook
  }
  def off(): Unit = {
    r.state = r.roboticOff
    println("Robot is switched off")
  }
}
