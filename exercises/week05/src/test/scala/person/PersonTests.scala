package person

import org.scalatest.FunSuite

class PersonTests extends FunSuite {

  test("apply method correctly assigns value to first name field") {
    val p1 = Person("John Smith")
    assert(p1.first == "John")
  }

  test("apply method correctly assigns value to last name field") {
    val p1 = Person("John Smith")
    assert(p1.last == "Smith")
  }


}
