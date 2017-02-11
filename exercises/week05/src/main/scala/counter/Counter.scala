package counter

class Counter(var count: Int) {
  def inc: Counter = Counter(count + 1)

  def dec: Counter = Counter(count - 1)

}

object Counter{
  def apply(count: Int) = new Counter(count)
}
