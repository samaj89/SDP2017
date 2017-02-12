package films

import org.scalatest.FunSuite

class DirectorTests extends FunSuite {

  test("name returns full name of Director") {
    val d1 = new Director("James", "Cameron", 1954)
    assert(d1.name === "James Cameron")
  }

}
