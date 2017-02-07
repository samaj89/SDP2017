/**
  * Created by samaj on 06/02/17.
  */

import org.junit.{Before}
import sml.{Labels, Machine}

class SMLTests {
  val m = new Machine(Labels(), Vector())

  @Before def resetMachine() = {
    for (i <- 0 until m.regs.size) m.regs.update(i, 0)
  }

}
