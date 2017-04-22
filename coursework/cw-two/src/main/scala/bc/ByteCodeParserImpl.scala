package bc

class ByteCodeParserImpl extends ByteCodeParser {

  val bcf = new ByteCodeFactoryImpl

  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    *
    * You should use [[bc.ByteCodeValues.bytecode]] to help translate
    * the individual `Byte`s into a correponding [[ByteCode]].
    *
    * @param bc a vector of bytes representing bytecodes
    * @return a vector of `ByteCode` objects
    */
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    var result:Vector[ByteCode] = Vector[ByteCode]()
    var i = 0
    while(i < bc.length) {
      if (bc(i) == bytecode("iconst")) {
        result = result :+ bcf.make(bc(i), bc(i+1).toInt)
        i=i+1
      } else {
        result = result :+ bcf.make(bc(i))
      }
      i = i+1
    }
    result
  }
}
