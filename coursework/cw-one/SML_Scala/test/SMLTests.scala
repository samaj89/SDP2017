/**
  * Created by samaj on 06/02/17.
  */

import org.junit.{Before, Test}
import org.junit.Assert.assertTrue
import sml._

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
    assertTrue(output == "L3: sub 1 - 2 to 2")
  }

  @Test def multiplyPositiveByPositive() = {
    LinInstruction("L!", 1, 10).execute(m)
    LinInstruction("L2", 2, 7).execute(m)
    MulInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 70)
  }

  @Test def multiplyPositiveByNegative() = {
    LinInstruction("L!", 1, 10).execute(m)
    LinInstruction("L2", 2, -7).execute(m)
    MulInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == -70)
  }

  @Test def multiplyNegativeByNegative() = {
    LinInstruction("L!", 1, -10).execute(m)
    LinInstruction("L2", 2, -7).execute(m)
    MulInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 70)
  }

  @Test def multiplyByZero() = {
    LinInstruction("L!", 1, 10).execute(m)
    LinInstruction("L2", 2, 0).execute(m)
    MulInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 0)
  }

  @Test def multiplyRegisterContentsByItself() = {
    LinInstruction("L!", 1, 10).execute(m)
    MulInstruction("L2", 1, 1, 1).execute(m)
    assertTrue(m.regs(3) == 100)
  }

  @Test def MulInstructionToStringReflectsContents() = {
    val output = MulInstruction("L3", 2, 1, 2).toString()
    assertTrue(output == "L3: mul 1 * 2 to 2")
  }

}
