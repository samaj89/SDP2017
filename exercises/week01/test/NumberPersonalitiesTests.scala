/**
  * Created by samaj on 18/01/17.
  */

import org.scalatest.FunSuite

class NumberPersonalitiesTests extends FunSuite {

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

  test("1 is a happy number") {
    assert(NumberPersonalities.isHappy(1) === true)
  }

  test("2 is not a happy number") {
    assert(NumberPersonalities.isHappy(2) === false)
  }

  test("495 is not a happy number") {
    assert(NumberPersonalities.isHappy(495) === false)
  }

  test("998 is a happy number") {
    assert(NumberPersonalities.isHappy(998) === true)
  }
}
