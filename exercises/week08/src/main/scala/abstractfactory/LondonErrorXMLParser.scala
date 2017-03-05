package abstractfactory

class LondonErrorXMLParser extends XMLParser {
  override def parse: String = {
    println("London Parsing error XML...")
    "London Error XML Message"
  }
}
