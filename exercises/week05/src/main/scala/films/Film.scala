package films

class Film(private val _name: String, private val _yearOfRelease: Int,
           private val _imdbRating: Double, private val _director: Director) {

  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director): Boolean = director.equals(this.director)

  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating, director: Director = this.director): Film =
    new Film(name, yearOfRelease, imdbRating, director)

  def name = _name
  def yearOfRelease = _yearOfRelease
  def imdbRating = _imdbRating
  def director = _director

}

object Film {
  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) =
    new Film(name, yearOfRelease, imdbRating, director)

  def highestRating(f1: Film, f2: Film): Double =
    if (f1.imdbRating > f2.imdbRating) f1.imdbRating else f2.imdbRating

  def oldestDirectorAtTheTime(f1: Film, f2: Film): Director =
    if (f1.directorsAge > f2.directorsAge) f1.director else f2.director
}
