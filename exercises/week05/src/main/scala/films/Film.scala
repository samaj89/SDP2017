package films

class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {

  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director): Boolean = director.equals(this.director)

}
