package sample_questions

/**
  * All is not well in Middle Earth. A company of exiled dwarves of the Lonely Mountain
  * have decided to recapture their home, which has fallen prey to Smaug, a terrifying
  * dragon. Before they are ready to wage war, however, they deem it important to find a
  * leader who can unite them and raise an army. Being proud people, each dwarf of the
  * company considers himself a valuable and deserving leader.
  *
  * To avoid unnecessary quarrels and bloodshed, the dwarves agree that they will elect a
  * leader after a sword forging contest. Renowned for their craftsmanship, the dwarves
  * face each other in a one-to-one race; the quickest one to forge a sword will win (There
  * is no need to doubt the quality of the sword, these are dwarves after all). To remove
  * any element of chance, each dwarf competes against every other dwarf twice, a “home”
  * and “away” duel.
  *
  * During their visit to the Shire, they come to you, a Scala expert, for help. They would
  * like you to determine all the duels that need to take place for a full tournament. For
  * convenience, you define a type alias for a due
  */

object Question38 {

  type Duel = (String, String)

  /**
    * Write a duels function, which, given a list of names, produces a list of pairings/duels
    * that should take place. Write your solutions using higher-order functions on List.
    */

  def duels1(dwarves: List[String]): List[Duel] = {
    dwarves.flatMap(x => dwarves.map(y => (x, y))).filter(duel => duel._1 != duel._2)
  }

  /**
    * ne of the dwarves, Gloin, is a little bit dense, but also eager to learn, and he
    * does not know of higher-order functions. He requests you for an explanation, and
    * you kindly oblige by writing it with for comprehensions only.
    */

  def duels2(dwarves: List[String]): List[Duel] = {
    for (x <- dwarves; y <- dwarves if x != y) yield (x, y)
  }

  /**
    * After a long and tiring tournament, the scores are out. Your Scala skills are called
    * on final time to pick the winner. The scores are given as a list of pairs, where the
    * first element of the pair is itself a pair describing a duel, and the second element
    * is an integer of value 1 or -1. If the value is 1, it means the first person in the pair
    * won the duel, while a -1 indicates a victory for the second person.
    *
    * Write a function that, given such a list, returns the name of the winner of the tournament.
    * You can safely assume that there is only one winner, and that the list is non-empty.
    *
    * Hint: you are welcome to use higher-order functions on Map and List that you
    * have seen.
    */

  def winner(duels: List[(Duel, Int)]): String = {
    def winnerHelper(duels: List[(Duel, Int)], acc: List[String]): List[String] = duels match {
      case Nil => acc
      case (duel, 1) :: t => winnerHelper(t, acc :+ duel._1)
      case (duel, -1) :: t => winnerHelper(t, acc :+ duel._2)
    }
    winnerHelper(duels, List()).groupBy(identity).toList.sortBy(_._2.length).reverse.head._1
  }

  def main(args: Array[String]): Unit = {
    println(duels1(List("Thorin", "Gloin", "Balin")))
    println(duels2(List("Thorin", "Gloin", "Balin")))
    println(winner(List((("Thorin","Gloin"),1), (("Thorin","Balin"), -1), (("Gloin","Thorin"), -1),
      (("Gloin","Balin"),1), (("Balin","Thorin"), -1), (("Balin","Gloin"), 1))))
  }

}
