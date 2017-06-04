package akka

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

object Fibonacci extends App {

  val fibList = List(23000, 12000, 31000, 150000, 400000, 200000, 170000)

  val system = ActorSystem("fibonacci")
  val collector = system.actorOf(Props(new FibonacciCollector(fibList)), "collector")

}

class FibonacciCollector(fibs: List[Int]) extends Actor with ActorLogging {
  var result: List[BigInt] = Nil
  var size = fibs.size

  for (n <- fibs) {
    context.actorOf(Props(new FibonacciCalculator)) ! n
  }


  def receive = {
    case (n: Int, fib: BigInt) => {
      log.info(s"Fibonacci number at $n: $fib")
      result :+= fib
      size -= 1

      if (size == 0) context.system.terminate()
    }
  }
}

class FibonacciCalculator extends Actor {

  def receive = {
    case n: Int => sender ! (n, fib(n))
  }

  def fib(n: Int): BigInt = {
    def fibHelper(n: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = n match {
      case 0 => prev
      case 1 => next
      case _ => fibHelper(n - 1, next, prev + next)
    }

    fibHelper(n)
  }
}