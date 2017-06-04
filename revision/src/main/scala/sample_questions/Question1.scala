package sample_questions

/**
  * Create a method manyTimesString that takes a String and an Int as arguments
  * and returns the String duplicated that many times. Print your answer.
  */

object Question1 {

  def manyTimesString(str: String, n: Int): String = {
    def helper(str: String, n: Int, acc: String): String = {
      if (n <= 0) acc else helper(str, n - 1, acc + str)
    }

    helper(str, n, "")
  }

  def main(args: Array[String]): Unit = {
    println(manyTimesString("abc", 3))
    println(manyTimesString("123", 2))
  }

}
