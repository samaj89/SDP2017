package composite

import java.util.ArrayList
import java.util.List

abstract class HtmlTag(tagName: String) {
  var tagBody: String
  var children = new ArrayList[HtmlTag]()

  def getTagName: String = tagName

  def setStartTag(tag: String)

  def setEndTag(tag: String)

  def setTagBody(tagBody: String) = this.tagBody = tagBody

  def addChildTag(htmlTag: HtmlTag) = children add htmlTag

  def removeChildTag(htmlTag: HtmlTag) = {
    val index = children.indexOf(htmlTag)
    if (index != -1) children remove index
  }

  def getChildren: List[HtmlTag] = children

  def generateHtml
}