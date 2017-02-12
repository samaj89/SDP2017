package films

import org.scalatest.FunSuite

class FilmTests extends FunSuite {
  val d1 = new Director("James", "Cameron", 1954)
  val d2 = new Director("Stanley", "Kubrick", 1928)
  val f1 = new Film("Titanic", 1997, 7.7, d1)

  test("diretorsAge returns correct age of director") {
    assert(f1.directorsAge === 43)
  }

  test("isDirectedBy returns true when director is correct") {
    assert(f1.isDirectedBy(d1) === true)
  }

  test("isDirectedBy returns true when director is correct") {
    assert(f1.isDirectedBy(d2) === false)
  }

}
