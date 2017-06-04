package sample_questions

import scala.math.abs

/**
  * The golden ratio, a/b, satisfies the equality a + b/a = a/b
  *
  * Write a Scala program to estimate the golden ratio recursively to within a specified
  * accuracy.
  */

object Question36 {

  def estimateB(a: Double, bMin: Double, bMax: Double, err: Double): Double = {
    val estB = (bMax + bMin) / 2
    val ratio1 = (a + estB) / a
    val ratio2 = a / estB
    if (abs(ratio1 - ratio2) < err) estB
    else if (ratio2 > ratio1) estimateB(a, estB, bMax, err)
    else estimateB(a, bMin, estB, err)
  }

  def main(args: Array[String]): Unit = {
    val a = 10.0
    val b = estimateB(a, 0, a, .000000000000000000000000001)
    println("Estimate is " + (a/b))
  }

}
