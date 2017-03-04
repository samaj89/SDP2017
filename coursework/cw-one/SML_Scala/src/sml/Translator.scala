package sml

import scala.util.{Failure, Success, Try}

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
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
        // ******* REFLECTION *******
        // Construct class name and get class of instruction
        val instrType = fields(1)
        val className = "sml." + instrType.capitalize + "Instruction"
        try {
          val newInstr = Class.forName(className)
          // Get class's default constructor
          val cons = newInstr.getConstructors()(0)
          // Get arguments for constructor
          var args = new Array[Object](fields.length)
          for (i <- 0 until fields.length) {
            Try(fields(i).toInt) match {
              case Success(x) => args(i) = new Integer(x)
              case Failure(e) => args(i) = fields(i)
            }
          }
          // Invoke constructor and add instruction to program
          val instruction = cons.newInstance(args: _*).asInstanceOf[Instruction]
          program = program :+ instruction
        } catch {
          case ex: ClassNotFoundException => println(s"Unknown instruction $instrType")
        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
