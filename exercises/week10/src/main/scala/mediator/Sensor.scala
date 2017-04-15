package mediator

class Sensor {
  def checkTemperature(temp: Int): Boolean = {
    println("Temperature is set to " + temp)
    true
  }
}