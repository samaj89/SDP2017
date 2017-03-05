package abstractfactory

class LondonOrderXMLParser extends XMLParser {
  override def parse: String = {
    println("London Parsing order XML...")
    "London Order XML Message"
  }
}
