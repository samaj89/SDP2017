package abstractfactory

class NYCParserFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = ???
}
