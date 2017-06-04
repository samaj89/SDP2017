package sample_questions

/**
  * Demonstrate that named and default arguments can be used with methods. Create a
  * class Item that takes two class arguments: A String for name and a Double for price.
  *
  * Add a method cost which has named arguments for grocery (Boolean), medication
  * (Boolean), and taxRate (Double). Default grocery and medication to false, taxRate
  * to 0.10.
  *
  * In this scenario, groceries and medications are not taxable. Return the total cost of
  * the item by calculating the appropriate tax.
  */

object Question3 {

  class Item(name: String, price: Double) {
    def cost(grocery: Boolean = false, medication: Boolean = false,
             taxRate: Double = 0.10): Double = {
      if (grocery || medication) price else price * (1 + taxRate)
    }
  }

  def main(args: Array[String]): Unit = {
    val flour = new Item(name="flour", 4)
    println(flour.cost(grocery=true))
    val sunscreen = new Item(name="sunscreen", 3)
    println(sunscreen.cost())
    val tv = new Item(name="television", 500)
    println(tv.cost(taxRate = 0.06))
  }

}
