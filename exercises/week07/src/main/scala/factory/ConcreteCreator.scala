package factory

class ConcreteCreator extends Creator {
  var newProduct: Product = null

  override def makeProduct(s: String): Product = {
    if (s equals "C") newProduct = new ConcreteProduct
    else if (s equals "O") newProduct = new OtherConcreteProduct
    newProduct
  }
}
