package counter

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

object Adder{
  def apply(amount: Int) = new Adder(amount)
}