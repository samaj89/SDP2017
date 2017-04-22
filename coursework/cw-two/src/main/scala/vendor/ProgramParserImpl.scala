package vendor

import scala.io.Source

class ProgramParserImpl extends ProgramParser {
  override type InstructionList = Vector[Instruction]

  def InstructionList(input: Instruction*) = Vector(input: _*)
  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  override def parse(file: String): InstructionList = {
    var list = InstructionList()
    for (line <- Source.fromFile(file).getLines()) {
      list = list++:parseString(line)
    }
    list
  }

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String): InstructionList = {
    val storeArray = string.split("\n")
    var list = InstructionList()
    for(string <- storeArray) {
      if (string contains " ") {
        val store = string.split(" ")
        val newInstr = new Instruction(store(0), Vector[Int](store(1).toInt))
        list = list:+newInstr
      } else {
        val newInstr = new Instruction(string, Vector[Int]())
        list = list:+newInstr
      }
    }
    list
  }
}
