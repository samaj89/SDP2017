package mediator

class Motor {

  def startMotor(): Unit = println("Start motor...")

  def rotateDrum(rpm: Int): Unit = println("Rotating drum at " + rpm + " rpm.")
}