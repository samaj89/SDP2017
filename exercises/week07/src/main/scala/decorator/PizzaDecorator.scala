package decorator

abstract class PizzaDecorator(tempPizza: Pizza) extends Pizza {
  override def getDesc: String = tempPizza.getDesc

  override def getPrice: Double = tempPizza.getPrice
}
