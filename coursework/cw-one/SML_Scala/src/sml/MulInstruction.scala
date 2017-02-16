package sml

/**
  * Created by samaj on 16/02/17.
  */
class MulInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) = ???

  override def toString(): String = ???

}
