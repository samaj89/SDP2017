package composite

import java.util.{ArrayList, List, Iterator}

case class HtmlParentElement(s: String) extends HtmlTag(s) {
  var children = new ArrayList[HtmlTag]()

  override def setStartTag(tag: String) = {
    startTag = tag
  }

  override def setEndTag(tag: String) = {
    endTag = tag
  }

  override def addChildTag(htmlTag: HtmlTag): Boolean = children add htmlTag

  override def removeChildTag(htmlTag: HtmlTag): Unit = {
    val index = children indexOf htmlTag
    if (index != -1) children remove index
  }

  override def getChildren: List[HtmlTag] = children

  override def generateHtml = {
    println(startTag)
    val iterator: Iterator[_] = getChildren.iterator
    while (iterator.hasNext) {
      {
        val element: HtmlTag = iterator.next.asInstanceOf[HtmlTag]
        element.generateHtml
      }
    }
    println(endTag)
  }
}
