package sample_questions

/**
  * Create a case class to represent a Person in an address book, complete with Strings
  * for the name and a String for contact information.
  */

object Question5 {

  case class Person(first: String, last: String, email: String)

  def main(args: Array[String]): Unit = {
    val p = Person("Jane", "Smile", "jane@smile.com")
    println(p.first)
    println(p.last)
    println(p.email)
  }

}
