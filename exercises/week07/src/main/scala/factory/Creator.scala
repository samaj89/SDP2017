package factory

abstract class Creator {
  def makeProduct(s: String): Product
}
