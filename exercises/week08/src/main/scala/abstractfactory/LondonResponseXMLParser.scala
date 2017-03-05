package abstractfactory

class LondonResponseXMLParser extends XMLParser {
  override def parse: String = {
    println("London Parsing response XML...")
    "London Response XML Message"
  }
}
