package films

class Director(firstName: String, lastName: String, private val _yearOfBirth: Int) {

  def name: String = firstName + " " + lastName

  def yearOfBirth = _yearOfBirth
}

object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int) =
    new Director(firstName, lastName, yearOfBirth)

  def older(d1: Director, d2: Director) = if (d1.yearOfBirth < d2.yearOfBirth) d1 else d2
}
