package sample_questions

/**
  * Write a recursive method fib which, given an integer n computes and returns the
  * n−th Fibonacci number. Use recursion in your implementation.
  */

object Question39 {

  def fib(n: Int): BigInt = {
    def fibHelper(n: Int, prev: Int = 0, next: Int = 1): BigInt = n match {
      case 0 => prev
      case 1 => next
      case _ => fibHelper(n - 1, next, prev + next)
    }

    fibHelper(n)
  }

  def main(args: Array[String]): Unit = {
    println(fib(45))
  }

}
