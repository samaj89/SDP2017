package person

case class Person(first: String, last: String) {

}

object Person {
  def apply(name: String) = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}
