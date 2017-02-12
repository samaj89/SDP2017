package films

class Director(firstName: String, lastName: String, private val _yearOfBirth: Int) {

  def name: String = firstName + " " + lastName

  def yearOfBirth = _yearOfBirth
}
