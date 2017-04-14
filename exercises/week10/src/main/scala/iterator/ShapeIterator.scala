package iterator

import java.util.Iterator

class ShapeIterator(private var shapes: Array[Shape]) extends Iterator[Shape] {

  var position: Int = -1

  override def hasNext(): Boolean = position < shapes.length - 1

  override def next(): Shape = {
    if (hasNext) {
      val next: Shape = shapes(position + 1)
      position += 1
      next
    } else null
  }

  override def remove(): Unit = {
    shapes = shapes.filter(s => s.id != position)
  }
}