package visitor

case class HtmlParentElement(var tagName: String) extends HtmlTag {
  var startTag: String = ""
  var endTag: String = ""

  private var childrenTag: List[HtmlTag] = List()

  override def addChildTag(htmlTag: HtmlTag): Unit = {
    childrenTag = childrenTag :+ htmlTag
  }
  override def removeChildTag(htmlTag: HtmlTag): Unit = {
    childrenTag = childrenTag.filter(tag => !(tag equals htmlTag))
  }
  override def getChildren() = childrenTag
  override def generateHtml(): Unit = {
    println(startTag)
    childrenTag.foreach(tag => tag.generateHtml)
    println(endTag)
  }
  override def accept(visitor: Visitor): Unit = visitor.visit(this)

  def getEndTag(): String = endTag
  def getStartTag(): String = startTag
  def getTagName(): String = tagName
  def setEndTag(tag: String): Unit = {
    endTag = tag
  }
  def setStartTag(tag: String): Unit = {
    startTag = tag
  }
}
