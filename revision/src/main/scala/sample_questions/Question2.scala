package sample_questions

/**
  * Define a class SimpleTime that takes two arguments: an Int that represents hours,
  * and an Int that represents minutes. Use named arguments to create a SimpleTime
  * object.
  */

object Question2 {

  class SimpleTime(val hours: Int, val minutes: Int)

  def main(args: Array[String]): Unit = {
    val t = new SimpleTime(hours = 5, minutes = 30)
    println("t.hours: " + t.hours)
    println("t.minutes: " + t.minutes)
  }

}
