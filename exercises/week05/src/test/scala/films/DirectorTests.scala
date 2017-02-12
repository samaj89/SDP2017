package films

import org.scalatest.FunSuite

class DirectorTests extends FunSuite {

  test("name returns full name of Director") {
    val d1 = new Director("James", "Cameron", 1954)
    assert(d1.name === "James Cameron")
  }

  test("apply returns new Director") {
    val d2 = Director.apply("Stanley", "Kubrick", 1928)
    assert(d2.name === "Stanley Kubrick")
  }

  test("older returns older director") {
    val d1 = new Director("James", "Cameron", 1954)
    val d2 = Director.apply("Stanley", "Kubrick", 1928)
    val d3 = Director.older(d1, d2)
    assert(d3.name === "Stanley Kubrick")
  }

}
