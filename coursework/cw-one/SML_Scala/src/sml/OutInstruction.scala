package sml

/**
  * Created by samaj on 18/02/17.
  */
class OutInstruction(label: String, op: String, val op1: Int)
  extends Instruction(label, op){

  override def execute(m: Machine) = println(m.regs(op1))

  override def toString(): String = super.toString + " print contents of " + op1 + "\n"

}

object OutInstruction {
  def apply(label: String, op1: Int) = new OutInstruction(label, "out", op1)
}
