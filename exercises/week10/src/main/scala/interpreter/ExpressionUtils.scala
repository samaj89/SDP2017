package interpreter

object ExpressionUtils {

  def isOperator(s: String): Boolean = {
    if ((s equals "+") || (s equals "-") ||
      (s equals "*") || (s equals "/")) true else false
  }

  def getOperator(s: String, left: Expression, right: Expression): Expression = s match {
    case "+" => new Add(left, right)
    case "-" => new Subtract(left, right)
    case "*" => new Product(left, right)
    case "/" => new Divide(left, right)
  }
}