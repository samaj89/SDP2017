package vm

import bc.{ByteCode, ByteCodeParserImpl, ByteCodeValues, InvalidBytecodeException}
import vendor.{Instruction, ProgramParserImpl}

class VirtualMachineParserImpl extends VirtualMachineParser with ByteCodeValues {
  val programparser = new ProgramParserImpl
  val bytecodeparser = new ByteCodeParserImpl
  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String): Vector[ByteCode] = {
    val vectorOfInstructions = programparser.parse(file)
    val vectorOfBytes = convertInstructionsToBytes(vectorOfInstructions)
    bytecodeparser.parse(vectorOfBytes)
  }

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a string into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program string correctly.
    *
    * @param str a string containing a program
    * @return a vector of bytecodes
    */
  override def parseString(str: String): Vector[ByteCode] = {
    val vectorOfInstructions = programparser.parseString(str)
    val vectorOfBytes = convertInstructionsToBytes(vectorOfInstructions)
    bytecodeparser.parse(vectorOfBytes)
  }

  /**
    * A helper method that converts a vector of Instructions to a
    * vector of Bytes to pass into the byte code parser.
    *
    * @param vectorOfInstructions a vector of Instructions
    * @return a vector of Bytes
    */
  private def convertInstructionsToBytes(vectorOfInstructions: Vector[Instruction]): Vector[Byte] = {
    var vectorOfBytes:Vector[Byte] = Vector[Byte]()
    for (x <- vectorOfInstructions) {
      if (bytecode.contains(x.name)) {
        vectorOfBytes = vectorOfBytes :+ bytecode(x.name)
        if (x.args.length > 0) {
          vectorOfBytes = vectorOfBytes :+ x.args(0).toByte
        }
      } else {
        throw new InvalidBytecodeException("invalid bytecode value")
      }
    }
    vectorOfBytes
  }
}
