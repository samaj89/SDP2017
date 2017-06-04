package sample_questions

/**
  * Create an anonymous function with three arguments ( temperate, low, and high).
  * The anonymous function will return true if the temperature is between high and
  * low, and false otherwise. Assign the anonymous function to a def and then call your
  * function.
  */

object Question6 {

  def between = (temperature:Int, low:Int, high:Int) =>
    if (temperature >= low && temperature <= high) true else false

  def main(args: Array[String]): Unit = {
    println(between(70, 80, 90))
    println(between(70, 60, 90))
  }

}
