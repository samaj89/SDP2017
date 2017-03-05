package abstractfactory

class NYCParserFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType match {
    case "NYCORDER" => new NYCOrderXMLParser
    case "NYCERROR" => new NYCErrorXMLParser
    case "NYCFEEDBACK" => new NYCFeedbackXMLParser
    case "NYCRESPONSE" => new NYCResponseXMLParser
  }
}
