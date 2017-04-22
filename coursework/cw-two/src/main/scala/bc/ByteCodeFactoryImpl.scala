package bc

class ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {
  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[bc.ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method should throw an [[bc.InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = byte match {
    case byte if byte == bytecode("iconst") => {
      if (args.length == 0) {
        throw new InvalidBytecodeException("invalid bytecode value")
      } else {
        new Iconst(args(0))
      }
    }
    case byte if byte == bytecode("iadd") => new Iadd
    case byte if byte == bytecode("isub") => new Isub
    case byte if byte == bytecode("imul") => new Imul
    case byte if byte == bytecode("idiv") => new Idiv
    case byte if byte == bytecode("irem") => new Irem
    case byte if byte == bytecode("ineg") => new Ineg
    case byte if byte == bytecode("iinc") => new Iinc
    case byte if byte == bytecode("idec") => new Idec
    case byte if byte == bytecode("iswap") => new Iswap
    case byte if byte == bytecode("idup") => new Idup
    case byte if byte == bytecode("print") => new Print
    case _ => throw new InvalidBytecodeException("invalid bytecode value")
  }


}
