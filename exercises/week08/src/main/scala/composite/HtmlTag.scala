package composite

import java.util.List

abstract class HtmlTag(tagName: String) {
  var tagBody: String

  def getTagName: String = tagName

  def setStartTag(tag: String)

  def setEndTag(tag: String)

  def setTagBody(tagBody: String) = {
    this.tagBody = tagBody
  }

  def addChildTag(htmlTag: HtmlTag) = throw new UnsupportedOperationException

  def removeChildTag(htmlTag: HtmlTag) = throw new UnsupportedOperationException

  def getChildren: List[HtmlTag] = throw new UnsupportedOperationException

  def generateHtml
}