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
    LinInstruction("L1", 1, 10).execute(m)
    LinInstruction("L2", 2, 7).execute(m)
    SubInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 3)
  }

  @Test def subtractNegativeFromPositive() = {
    LinInstruction("L1", 1, 10).execute(m)
    LinInstruction("L2", 2, -7).execute(m)
    SubInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 17)
  }

  @Test def placeSubtractResultInOccupiedRegister() = {
    LinInstruction("L1", 1, 10).execute(m)
    LinInstruction("L2", 2, -7).execute(m)
    SubInstruction("L3", 2, 1, 2).execute(m)
    assertTrue(m.regs(2) == 17)
  }

  @Test def SubInstructionToStringReflectsContents() = {
    val output = SubInstruction("L3", 2, 1, 2).toString()
    assertTrue(output == "L3: sub 1 - 2 to 2\n")
  }

  @Test def multiplyPositiveByPositive() = {
    LinInstruction("L1", 1, 10).execute(m)
    LinInstruction("L2", 2, 7).execute(m)
    MulInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 70)
  }

  @Test def multiplyPositiveByNegative() = {
    LinInstruction("L1", 1, 10).execute(m)
    LinInstruction("L2", 2, -7).execute(m)
    MulInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == -70)
  }

  @Test def multiplyNegativeByNegative() = {
    LinInstruction("L1", 1, -10).execute(m)
    LinInstruction("L2", 2, -7).execute(m)
    MulInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 70)
  }

  @Test def multiplyByZero() = {
    LinInstruction("L1", 1, 10).execute(m)
    LinInstruction("L2", 2, 0).execute(m)
    MulInstruction("L3", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 0)
  }

  @Test def multiplyRegisterContentsByItself() = {
    LinInstruction("L1", 1, 10).execute(m)
    MulInstruction("L2", 1, 1, 1).execute(m)
    assertTrue(m.regs(1) == 100)
  }

  @Test def MulInstructionToStringReflectsContents() = {
    val output = MulInstruction("L3", 2, 1, 2).toString()
    assertTrue(output == "L3: mul 1 * 2 to 2\n")
  }

  @Test def OutInstructionToStringReflectsContents() = {
    val output = OutInstruction("L1", 1).toString()
    assertTrue(output == "L1: out print contents of 1\n")
  }

  @Test def BnzInstructionToStringReflectsContents() = {
    val output = BnzInstruction("L1", 1, "L3").toString()
    assertTrue(output == "L1: bnz if contents of 1 is not 0 branch to L3\n")
  }

  @Test def BnzInstructionBranchesIfRegisterNotZero() = {
    m.pc = 2
    m.regs(1) = 1
    m.labels.add("L1")
    m.labels.add("L2")
    m.labels.add("L3")
    BnzInstruction("L3", 1, "L2").execute(m)
    assertTrue(m.pc == 1)
  }

  @Test def BnzInstructionDoesNotBranchIfRegisterZero() = {
    m.pc = 2
    m.labels.add("L1")
    m.labels.add("L2")
    m.labels.add("L3")
    BnzInstruction("L3", 1, "L2").execute(m)
    assertTrue(m.pc == 2)
  }

  @Test def DividePositiveByPositive() = {
    LinInstruction("L1", 1, 10).execute(m)
    LinInstruction("L2", 2, 2).execute(m)
    DivInstruction("L3", 3, 1, 2).execute(m)
    println(m.regs(3))
    //assertTrue(m.regs(3) == 5)
  }

  @Test def DividePositiveByNegative() = {
    LinInstruction("L1", 1, 10).execute(m)
    LinInstruction("L2", 2, -2).execute(m)
    DivInstruction("L3", 3, 1, 2).execute(m)
    println(m.regs(3))
    //assertTrue(m.regs(3) == -5)
  }

  @Test def DividingZeroReturnsZero() = {
    LinInstruction("L1", 2, 2).execute(m)
    DivInstruction("L2", 3, 1, 2).execute(m)
    assertTrue(m.regs(3) == 0)
  }

  @Test def MultiplyingThenDividingReturnsOriginal() = {
    LinInstruction("L1", 1, 10).execute(m)
    LinInstruction("L2", 2, 2).execute(m)
    MulInstruction("L3", 3, 1, 2).execute(m)
    DivInstruction("L4", 4, 3, 2).execute(m)
    assertTrue(m.regs(4) == 10)
  }

  @Test def DividingRegisterContentsByItselfReturnsOne() = {
    LinInstruction("L1", 1, 10).execute(m)
    DivInstruction("L2", 1, 1, 1).execute(m)
    assertTrue(m.regs(1) == 1)
  }

  @Test def DivInstructionToStringReflectsContents() = {
    val output = DivInstruction("L3", 2, 1, 2).toString()
    assertTrue(output == "L3: div 1 / 2 to 2\n")
  }
}
