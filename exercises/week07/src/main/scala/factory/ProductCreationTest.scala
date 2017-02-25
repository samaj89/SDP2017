package factory

import java.util.Scanner

object ProductCreationTest extends App {
  val productFactory: Creator = new ConcreteCreator
  val userInput: Scanner = new Scanner(System.in)
  var theProduct: Product = null

  print("What type of product will you make? (enter C / O): ")
  if (userInput.hasNextLine) {
    val typeOfProduct: String = userInput.nextLine
    theProduct = productFactory.makeProduct(typeOfProduct)
    if (theProduct != null) {
      theProduct performFunction
    }
    else System.out.print("Please enter C or O next time")
  }
}
