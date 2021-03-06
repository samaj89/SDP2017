package functions

import functions.Funcs._
import org.scalatest.FunSuite

class FunctionsTestSuite extends FunSuite {
  // Basics
  test("Tail removes the first element") {
    assert(tail(List(1, 2, 3, 4)) == List(2, 3, 4))
  }

  test("Calling tail on empty list throws IllegalArgumentException") {
    intercept[IllegalArgumentException] {
      tail(List())
    }
  }

  test("Calling tail on single element list returns empty list") {
    assert(tail(List(1)) == Nil)
  }

  test("Calling tail on result of tail call removes first two elements") {
    assert(tail(tail(List(1, 2, 3, 4))) == List(3,4))
  }

  test("setHead changes the first element of the list") {
    assert(setHead(List("A", "B", "C"), "0") == List("0", "B", "C"))
  }

  test("Calling setHead on empty list returns list with single element") {
    assert(setHead(List(), "A") == List("A"))
  }

  test("Calling setHead on result of setHead call changes the first element of the list") {
    assert(setHead(setHead(List("A", "B", "C"), "O"), "X") == List("X", "B", "C"))
  }

  test("drop removes N elements from the front of the list") {
    assert(drop(List(1, 2, 3), 2) == List(3))
  }

  test("drop returns empty list if N equals list size") {
    assert(drop(List(1, 2, 3), 3) == Nil)
  }

  test("drop returns empty list if N exceeds list size") {
    assert(drop(List(1, 2, 3), 4) == Nil)
  }

  test("drop returns empty list if called on empty list") {
    assert(drop(List(), 3) == Nil)
  }

  test("Calling drop on result of drop call removes N1 + N2 elements from the front of the list") {
    assert(drop(drop(List(1, 2, 3, 4, 5), 2), 2) == List(5))
  }

  test("init removes the last element") {
    assert(init(List("A", "B", "C", "D")) == List("A", "B", "C"))
  }

  test("Calling init on empty list throws IllegalArgumentException") {
    intercept[IllegalArgumentException] {
      init(List())
    }
  }

  test("Calling init on single element list returns empty list") {
    assert(init(List(1)) == Nil)
  }

  test("Calling init on result of init call removes last two elements") {
    assert(init(init(List(1, 2, 3, 4))) == List(1,2))
  }

  // Folding
  test("foldLeft computes the correct value") {
    assert(foldLeft(List("H", "e", "l", "l", "o"), "")(_ + _) == "Hello")
  }

  test("foldLeft on empty list returns initial value") {
    assert(foldLeft(List(), 0)((x: Int, y: Int) => x + y) == 0)
  }

  test("foldLeft on single element list returns element value") {
    assert(foldLeft(List(3), 0)((x, y) => x + y) == 3)
  }

  test("sum produces the correct sum") {
    assert(sum(List(1.0, 2.0, 3.0, -3.0, -2.0, -1.0)) == 0.0)
  }

  test("sum returns zero on empty list") {
    assert(sum(List()) == 0.0)
  }

  test("sum returns element value on single element list") {
    assert(sum(List(3.0)) == 3.0)
  }

  test("product produces the correct product") {
    assert(product(List(1.0, 2.0, 3.0, 4.0, 5.0)) == 120.0)
  }

  test("product returns 1.0 on empty list") {
    assert(product(List()) == 1.0)
  }

  test("product returns element value on single element list") {
    assert(product(List(3.0)) == 3.0)
  }

  test("length calculates the length") {
    assert(length("Hello".toList) == 5)
  }

  test("length returns 0 on empty list") {
    assert(length(List()) == 0)
  }

  test("length returns 1 for single element list") {
    assert(length(List("X")) == 1)
  }

  test("reverse reverses the list") {
    assert(reverse("Hello".toList) == "olleH".toList)
  }

  test("reverse reverses the list for even-length input") {
    assert(reverse("Hola".toList) == "aloH".toList)
  }

  test("reverse returns empty list on empty list input") {
    assert(reverse(List()) == List())
  }

  test("reverse returns copy of list on single element list input") {
    assert(reverse(List(2.0)) == List(2.0))
  }

  test("flatten flattens the nested list") {
    assert(flatten(List(List(1, 2, 3), List(4, 5, 6))) == List(1, 2, 3, 4, 5, 6))
  }

  test("flatten returns empty list on empty list input") {
    assert(flatten(List()) == List())
  }

  test("flatten flattens list of single element lists") {
    assert(flatten(List(List(1), List(2), List(3), List(4), List(5), List(6))) == List(1, 2, 3, 4, 5, 6))
  }

  test("flatten returns single element list on input of list of one single element list") {
    assert(flatten(List(List("X"))) == List("X"))
  }

  // Map and Filter
  test("map creates a new list of the correct values") {
    assert(map((1 to 10).toList)(_ + 1) == (2 to 11).toList)
  }

  test("map on empty list returns an empty list") {
    assert(map(List[Int]())(_ * 2) == List())
  }

  test("map on single element list returns single element list with correct value") {
    assert(map(List("X"))(x => x toLowerCase) == List("x"))
  }

  test("map on return of map call returns correct application of composite function") {
    assert(map(map(List(1, 2, 3, 4, 5))(_ * 2))(_ + 1) == List(3, 5, 7, 9, 11))
  }

  test("filter filters the list") {
    assert(filter((-5 to 5).toList)(_ > 0) == (1 to 5).toList)
  }

  test("filter returns empty list on empty list input") {
    assert(filter(List[Int]())(_ > 0) == List())
  }

  test("filter returns empty list if no element in list satisfies the predicate") {
    assert(filter((-5 to 5).toList)(_ > 10) == List())
  }

  test("filter returns original list if all elements in list satisfy the predicate") {
    assert(filter(List('a', 'b', 'c', 'd', 'e'))(x => x isLetter) == List('a', 'b', 'c', 'd', 'e'))
  }

  test("filter on return of filter call correctly filters list twice") {
    assert(filter(filter((1 to 20).toList)(x => x % 2 == 0))(x => x % 3 == 0) == List(6, 12, 18))
  }

  test("flatMap maps and flattens") {
    assert(flatMap((1 to 5).toList)(x => (x to 5).toList) ==
      List(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5))
  }

  // Combined

  test("maxAverage calculates the max average") {
    val list = List(1.0, 2.0, 3.0, 4.0, 5.0).map(x => (x, x + 10))
    assert(maxAverage(list) == 13.0)
  }

  test("variance calculates the correct variance") {
    val v = variance(List(1.0, 2.0, 3.0, 4.0, 5.0))
    assert(v == 2.0, "If you got 2.5, you divided by the wrong thing, probably.")
  }
}
