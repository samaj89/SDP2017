package sml

/**
  * Created by samaj on 18/02/17.
  */
class BnzInstruction(label: String, op: String, val op1: Int, goTo: String)
  extends Instruction(label, op){

  override def execute(m: Machine) = ???

  override def toString(): String = ???

}

object BnzInstruction {
  def apply(label: String, op1: Int, goTo: String) =
    new BnzInstruction(label, "bnz", op1, goTo)
}
