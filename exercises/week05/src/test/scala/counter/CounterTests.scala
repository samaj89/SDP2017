package counter

import org.scalatest.{FunSuite, BeforeAndAfter}

class CounterTests extends FunSuite with BeforeAndAfter {

  var counter: Counter = _

  before {
    counter = Counter(5)
  }

  test("inc should increase counter value by 1") {
    assert(counter.inc().count === 6)
  }

  test("multiple calls of inc should increment counter the correct amount") {
    assert(counter.inc().inc().inc().count === 8)
  }

  test("dec should decrease counter value by 1") {
    assert(counter.dec().count === 4)
  }

  test("multiple calls of dec should decrease counter the correct amount") {
    assert(counter.dec().dec().dec().dec().dec().dec().count === -1)
  }

  test("inc followed by dec should return original count") {
    assert(counter.inc().dec().count === 5)
  }

  test("dec followed by inc should return original count") {
    assert(counter.dec().inc().count === 5)
  }

  test("inc(2) increases counter value by 2") {
    assert(counter.inc(2).count === 7)
  }

  test("inc(-2) decreases counter value by 2") {
    assert(counter.inc(-2).count === 3)
  }

  test("inc(0) does not change counter value") {
    assert(counter.inc(0).count === 5)
  }

  test("dec(2) decreases counter value by 2") {
    assert(counter.dec(2).count === 3)
  }

  test("dec(-2) increases counter value by 2") {
    assert(counter.dec(-2).count === 7)
  }

  test("dec(0) does not change counter value") {
    assert(counter.dec(0).count === 5)
  }

  test("Default Counter has value 0") {
    assert(Counter().count == 0)
  }
}
