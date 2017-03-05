package abstractfactory

class LondonParserFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType match {
    case "LondonORDER" => new LondonOrderXMLParser
    case "LondonERROR" => new LondonErrorXMLParser
    case "LondonFEEDBACK" => new LondonFeedbackXMLParser
    case "LondonRESPONSE" => new LondonResponseXMLParser
  }
}
