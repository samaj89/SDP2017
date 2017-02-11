package counter

class Counter(var count: Int) {
  def inc(x: Int = 1): Counter = Counter(count + x)

  def dec(x: Int = 1): Counter = Counter(count - x)

}

object Counter{
  def apply(count: Int) = new Counter(count)
}
