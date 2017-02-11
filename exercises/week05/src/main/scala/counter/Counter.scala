package counter

case class Counter(count: Int = 0) {
  def inc(x: Int = 1): Counter = this.copy(count = count + x)

  def dec(x: Int = 1): Counter = this.copy(count = count - x)

  def adjust(adder: Adder): Counter = this.copy(count = adder.add(count))
}

