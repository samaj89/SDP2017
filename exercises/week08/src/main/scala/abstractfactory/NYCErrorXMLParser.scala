package abstractfactory

class NYCErrorXMLParser extends XMLParser {
  override def parse: String = {
    println("NYC Parsing error XML...")
    "NYC Error XML Message"
  }
}
