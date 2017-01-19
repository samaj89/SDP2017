/**
  * Created by samaj on 15/01/17.
  */
object NumberPersonalities {
  val limit = 100

  def main(args: Array[String]) {
    for (i <- 1 to limit) {
      println(i)
    }
  }

  def isPrime(n: Int) = {
    if (n == 1) false
    else if (n == 2) true
    else !(2 to (n-1)).exists(x => n % x == 0)
  }

  def isHappy(n: Int) = {
  }

  def isTriangular(n: Int): Boolean = {
    false
  }

  def isSquare(n: Int): Boolean = {
    false
  }

  def isSmug(n: Int): Boolean = {
    false
  }

  def isHonest(n: Int): Boolean = {
    false
  }

  def isPronic(n: Int): Boolean = {
    false
  }

  def isDeficient(n: Int): Boolean = {
    false
  }

  def isPerfect(n: Int): Boolean = {
    false
  }

  def isAbundant(n: Int): Boolean = {
    false
  }

  def sumOfPositiveDivisorsOf(n: Int): Int = {
    -99
  }
}
