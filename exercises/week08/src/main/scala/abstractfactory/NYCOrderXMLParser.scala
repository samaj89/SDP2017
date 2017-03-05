package abstractfactory

class NYCOrderXMLParser extends XMLParser {
  override def parse: String = {
    println("NYC Parsing order XML...")
    "NYC Order XML Message"
  }
}
