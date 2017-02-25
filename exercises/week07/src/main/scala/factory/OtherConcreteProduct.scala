package factory

class OtherConcreteProduct extends Product {
  override def performFunction = println("OtherConcreteProduct is faulty: cannot perform function")
}
