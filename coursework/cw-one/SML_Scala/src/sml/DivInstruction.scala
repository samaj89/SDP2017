package sml

/**
  * Created by samaj on 18/02/17.
  */

class DivInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
extends Instruction(label, op) {

  override def execute(m: Machine) = ???

  override def toString(): String = ???

}

object DivInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int) =
    new DivInstruction(label, "div", result, op1, op2)
}
