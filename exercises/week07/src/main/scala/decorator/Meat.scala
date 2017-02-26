package decorator

class Meat(pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {
  override def getDesc: String = pizza.getDesc + ", Meat (14.25)"

  override def getPrice: Double = pizza.getPrice + 14.25
}
