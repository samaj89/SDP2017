/**
  * Created by samaj on 18/01/17.
  */

import org.scalatest.FunSuite

object NumberPersonalitiesTests extends FunSuite {

  test("1 is not a prime number") {
    assert(NumberPersonalities.isPrime(1) === false)
  }

  test("2 is a prime number") {
    assert(NumberPersonalities.isPrime(2) === true)
  }

  test("199 is a prime number") {
    assert(NumberPersonalities.isPrime(199) === true)
  }

  test("205 is not a prime number") {
    assert(NumberPersonalities.isPrime(205) === false)
  }
}
