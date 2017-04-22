package bc

import vm.VirtualMachine

class Idup extends ByteCode {
  /**
    * A unique byte value representing the bytecode. An implementation
    * will set this to the bytecode corresponding to the name of the
    * bytecode in [[bc.ByteCodeValues]]
    */
  override val code: Byte = bytecode("idup")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    * Pop the top value from the stack and push it twice onto the stack,
    * duplicating the top value.
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val one = vm.pop()
    val store = one._2.push(one._1)
    store.push(one._1)
  }
}
