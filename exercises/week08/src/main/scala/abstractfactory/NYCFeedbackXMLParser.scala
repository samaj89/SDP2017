package abstractfactory

class NYCFeedbackXMLParser extends XMLParser {
  override def parse: String = {
    println("NYC Parsing feedback XML...")
    "NYC Feedback XML Message"
  }
}
