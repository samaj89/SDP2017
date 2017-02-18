package sml

/**
  * Created by samaj on 18/02/17.
  */
class OutInstruction(label: String, op: String, val op1: Int)
  extends Instruction(label, op){

  override def execute(m: Machine) = ???

  override def toString(): String = ???

}

object OutInstruction {
  def apply(label: String, op1: Int) = new OutInstruction(label, "out", op1)
}
