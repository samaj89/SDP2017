package films

class Film(private val _name: String, private val _yearOfRelease: Int,
           private val _imdbRating: Double, private val _director: Director) {

  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director): Boolean = director.equals(this.director)

  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating, director: Director = this.director): Film = ???

  def name = _name
  def yearOfRelease = _yearOfRelease
  def imdbRating = _imdbRating
  def director = _director

}
