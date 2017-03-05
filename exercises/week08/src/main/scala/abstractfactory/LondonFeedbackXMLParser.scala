package abstractfactory

class LondonFeedbackXMLParser extends XMLParser {
  override def parse: String = {
    println("London Parsing feedback XML...")
    "London Feedback XML Message"
  }
}
