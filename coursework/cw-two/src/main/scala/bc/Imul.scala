package bc

import vm.VirtualMachine

class Imul extends ByteCode {
  /**
    * A unique byte value representing the bytecode. An implementation
    * will set this to the bytecode corresponding to the name of the
    * bytecode in [[bc.ByteCodeValues]]
    */
  override val code: Byte = bytecode("imul")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    * Pop the top two values from the virtual machine stack and push the result
    * of multiplying them together
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val one = vm.pop()
    val two = one._2.pop()
    val result = one._1 * two._1
    two._2.push(result)
  }
}