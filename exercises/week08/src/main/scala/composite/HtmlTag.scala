package composite

import java.util.List

abstract class HtmlTag(tagName: String) {
  var tagBody = ""
  var startTag = ""
  var endTag = ""

  def getTagName: String = tagName

  def setStartTag(tag: String)

  def setEndTag(tag: String)

  def setTagBody(tagBody: String) = {
    this.tagBody = tagBody
  }

  def addChildTag(htmlTag: HtmlTag): Boolean = throw new UnsupportedOperationException

  def removeChildTag(htmlTag: HtmlTag): Unit = throw new UnsupportedOperationException

  def getChildren: List[HtmlTag] = throw new UnsupportedOperationException

  def generateHtml
}