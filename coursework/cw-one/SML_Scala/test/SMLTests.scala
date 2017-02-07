/**
  * Created by samaj on 06/02/17.
  */

import org.junit.{Before, Test}
import org.junit.Assert.{assertTrue}
import sml.{Labels, LinInstruction, Machine, SubInstruction}

class SMLTests {
  val m = new Machine(Labels(), Vector())

  @Before def resetMachine() = {
    for (i <- 0 until m.regs.size) m.regs.update(i, 0)
  }

  @Test def subtractPositiveFromPositive() = {
    LinInstruction("L!", 1, 10).execute(m)
    LinInstruction("L2", 2, 7).execute(m)
    SubInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 3)
  }

  @Test def subtractNegativeFromPositive() = {
    LinInstruction("L!", 1, 10).execute(m)
    LinInstruction("L2", 2, -7).execute(m)
    SubInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 17)
  }

  @Test def placeSubtractResultInOccupiedRegister() = {
    LinInstruction("L!", 1, 10).execute(m)
    LinInstruction("L2", 2, -7).execute(m)
    SubInstruction("L3", 2, 1, 2).execute(m)
    assertTrue(m.regs(2) == 17)
  }

  @Test def SubInstructionToStringReflectsContents() = {
    val output = SubInstruction("L3", 2, 1, 2).toString()
    assertTrue(output == "L3: sub 2 - 1 to 2")
  }

}
