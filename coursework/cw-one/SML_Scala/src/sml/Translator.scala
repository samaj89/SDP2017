package sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"
  private final val DIV = "div"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
        // ******* REFLECTION - TO DO *******
        // 1. Construct class name and get class of instruction
        val instrType = fields(1)
        val className = "sml." + instrType.capitalize + "Instruction"
        try {
          val newInstr = Class.forName(className)
          // 2. Get class's apply method
          val apply = newInstr.getMethod("apply")
          // 3. Get parameters to invoke class's apply method
          // 4. Invoke and add instruction to program
        } catch {
          case ex: ClassNotFoundException => println(s"No class of instruction [$instrType]")
        }

        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case SUB =>
            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case MUL =>
            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case OUT =>
            program = program :+ OutInstruction(fields(0), fields(2).toInt)
          case BNZ =>
            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
          case DIV =>
            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case x =>
            println(s"Unknown instruction $x")
        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
