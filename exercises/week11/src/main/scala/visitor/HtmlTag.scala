package visitor

abstract class HtmlTag extends Element {
  def getTagName(): String
  def setStartTag(tag: String): Unit
  def getStartTag(): String
  def getEndTag(): String
  def setEndTag(tag: String): Unit

  def setTagBody(tagBody: String): Unit = throw new UnsupportedOperationException("Current operation is not support for this object")
  def addChildTag(htmlTag: HtmlTag): Unit = throw new UnsupportedOperationException("Current operation is not support for this object")
  def removeChildTag(htmlTag: HtmlTag): Unit = throw new UnsupportedOperationException("Current operation is not support for this object")
  def getChildren(): List[HtmlTag] = throw new UnsupportedOperationException("Current operation is not support for this object")
  def generateHtml(): Unit
}
