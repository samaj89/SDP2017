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

  test("isDirectedBy returns false when director is incorrect") {
    assert(f1.isDirectedBy(d2) === false)
  }

  test("copy returns copy of Film with same fields") {
    val f2 = f1.copy()
    assert(f1.name equals f2.name)
    assert(f1.yearOfRelease equals f2.yearOfRelease)
    assert(f1.imdbRating equals f2.imdbRating)
    assert(f1.director equals f2.director)
  }

  test("copy with parameters returns copy of Film with changes") {
    val f3 = f1.copy(yearOfRelease = 2012, imdbRating = 10.0)
    assert(f1.name equals f3.name)
    assert(!(f1.yearOfRelease equals f3.yearOfRelease))
    assert(!(f1.imdbRating equals f3.imdbRating))
    assert(f1.director equals f3.director)
  }

}
