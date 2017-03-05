package composite

// TODO

case class HtmlElement(s: String) extends HtmlTag(s) {
  var tagBody = ""

  override def setStartTag(tag: String): Unit = ???

  override def setEndTag(tag: String): Unit = ???

  override def generateHtml: Unit = ???
}
