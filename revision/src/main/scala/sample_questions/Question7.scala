package sample_questions

/**
  * Use reduce to implement a method sumIt that takes a variable argument list and sums
  * those arguments.
  */

object Question7 {

  def sumIt(ints: Int*): Int = {
    ints.reduce(_ + _)
  }

  def main(args: Array[String]): Unit = {
    println(sumIt(1, 2, 3))
    println(sumIt(45, 45, 45, 60))
  }

}
