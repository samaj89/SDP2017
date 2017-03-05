package composite

// TODO

case class HtmlElement(s: String) extends HtmlTag(s) {

  override def setStartTag(tag: String) = {
    startTag = tag
  }

  override def setEndTag(tag: String) = {
    endTag = tag
  }

  override def generateHtml = println(startTag + tagBody + endTag)
}
