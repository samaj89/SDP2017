package sml

/**
  * Created by samaj on 18/02/17.
  */
class BnzInstruction(label: String, op: String, val op1: Int, goTo: String)
  extends Instruction(label, op){

  override def execute(m: Machine) = {
    if (m.regs(op1) != 0) {
      m.pc = m.labels.labels.indexOf(goTo)
    }
  }

  override def toString(): String =
    super.toString + " if contents of " + op1 + " is not 0 branch to " + goTo + "\n"

}

object BnzInstruction {
  def apply(label: String, op1: Int, goTo: String) =
    new BnzInstruction(label, "bnz", op1, goTo)

  def main(args: Array[String]): Unit = {
    println(BnzInstruction("L1", 1, "L3").toString())
  }
}
