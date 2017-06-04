package trees

import scala.annotation.tailrec

sealed trait Tree
final case class Node(lhs: Tree, v: Int, rhs: Tree) extends Tree
final case object Leaf extends Tree

object TreeOps extends App {

  def insert(n: Int, t: Tree): Tree = t match {
    case Leaf => Node(Leaf, n, Leaf)
    case Node(lhs, v, rhs) if n == v => Node(lhs, v, rhs)
    case Node(lhs, v, rhs) if n < v => Node(insert(n, lhs), v, rhs)
    case Node(lhs, v, rhs) => Node(lhs, v, insert(n, rhs))
  }

  def size(t: Tree): Int = t match {
    case Leaf => 0
    case Node(lhs, _, rhs) => 1 + size(lhs) + size(rhs)
  }

  def sizeTailRec(t: Tree): Int = {
    @tailrec
    def sizeAcc(lst: List[Tree], acc: Int): Int = lst match {
      case Nil => acc
      case Leaf :: t => sizeAcc(t, acc)
      case Node(lhs, _, rhs) :: t => sizeAcc(lhs :: rhs :: t, acc + 1)
    }

    sizeAcc(List(t), 0)
  }

  @tailrec
  def find(n: Int, t: Tree): Boolean = t match {
    case Leaf => false
    case Node(lhs, v, rhs) if n == v => true
    case Node(lhs, v, _) if n < v => find(n, lhs)
    case Node (_, v, rhs) => find(n, rhs)
  }

  def inOrderTraversal(t: Tree): String = t match {
    case Leaf => ""
    case Node(lhs, v, rhs) => inOrderTraversal(lhs) + " " + v.toString + " " + inOrderTraversal(rhs)
  }

  val t1 = Node(Leaf, 10, Leaf)
  val t2 = insert(1, insert(12, insert(10, insert(23, insert(7, insert(15, insert(5, t1)))))))
  println(t2)
  println(size(t2))
  println(sizeTailRec(t2))
  println(find(7, t2))
  println(find(19, t2))
  println(inOrderTraversal(t2))
}