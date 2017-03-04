import org.scalatest.FunSuite
import org.scalatest.Assertions
import strategy.{CapTextFormatter, LowerTextFormatter}

class StrategyTests extends FunSuite {

  val ctf = CapTextFormatter()
  val ltf = LowerTextFormatter()
  val input = "HeLlO, WoRlD!"

  test("CapTextFormatter converts string to all caps") {

    assert(ctf.format(input) === "HELLO, WORLD!")
  }

  test("LowerTextFormatter converts string to all lower case") {
    assert(ltf.format(input) === "hello, world!")
  }

}
