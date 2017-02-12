package films

class Director(firstName: String, lastName: String, private val _yearOfBirth: Int) {

  def name: String = firstName + " " + lastName

  def yearOfBirth = _yearOfBirth
}

object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int) = ???

  def older(d1: Director, d2: Director) = ???
}
