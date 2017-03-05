package abstractfactory

class LondonParserFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = ???
}
