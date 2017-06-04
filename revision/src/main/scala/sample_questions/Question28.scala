package sample_questions

/**
  * Write a method that inspects a 3x3 square of a Sudoku grid and returns true
  * if it contains one instance of each of the digits from 1 to 9. If it contains
  * an integer outside of that range or contains duplicated values, checkBlock
  * should return false
  */

object Question28 {

  type Matrix = Array[Array[Int]]

  def checkBlock(matrix: Matrix): Boolean = {
    matrix.flatten.filter(n => n <= 9).filter(n => n >= 1).distinct.length equals 9
  }

  def main(args: Array[String]): Unit = {
    println(checkBlock(Array(Array(1,2,3), Array(4,5,6), Array(7,8,9))))
    println(checkBlock(Array(Array(10,2,3), Array(4,5,6), Array(7,8,9))))
    println(checkBlock(Array(Array(3,2,3), Array(4,1,4), Array(7,7,9))))
  }

}
