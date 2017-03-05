package abstractfactory

object ParserFactoryProducer {
  var pf: AbstractParserFactory = null

  def getFactory(s: String) = {
    if (s equals "NYCFactory") pf = new NYCParserFactory
    else if (s equals "LondonFactory") pf = new LondonParserFactory
    pf
  }
}
