package sml

/**
  * Created by samaj on 07/02/17.
  */

class SubInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) = ???

  override def toString() = ???

}

object SubInstruction {
  def apply() = ???
}
