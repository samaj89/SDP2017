package bc

import vm.VirtualMachine

class Ineg extends ByteCode {
  /**
    * A unique byte value representing the bytecode. An implementation
    * will set this to the bytecode corresponding to the name of the
    * bytecode in [[bc.ByteCodeValues]]
    */
  override val code: Byte = bytecode("ineg")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    * Pop the the top value from the virtual machine stack, negate it, and push
    * the result.
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val one = vm.pop()
    val result = -one._1
    one._2.push(result)
  }
}
