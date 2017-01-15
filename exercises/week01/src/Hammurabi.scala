import scala.util.Random

/**
  * Created by samaj on 14/01/17.
  */
object Hammurabi {

  def printIntroductoryMessage() {
    println("""Congratulations, you are the newest ruler of ancient Samaria, elected
for a ten year term of office. Your duties are to dispense food, direct
farming, and buy and sell land as needed to support your people. Watch
out for rat infestations and the plague! Grain is the general currency,
measured in bushels. The following will help you in your decisions:

* Each person needs at least 20 bushels of grain per year to survive.
* Each person can farm at most 10 acres of land.
* It takes 2 bushels of grain to farm an acre of land.
* The market price for land fluctuates yearly.

Rule wisely and you will be showered with appreciation at the end of
your term. Rule poorly and you will be kicked out of office!
=======================================================================
""")
  }

  def readInt(message: String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _ : Throwable =>
        println("That’s not an integer. Please enter an integer.")
        readInt(message)
    }
  }

  def askHowMuchLandToBuy(bushels: Int, price: Int): Int = {
    var acresToBuy = readInt("How many acres will you buy? ")
    while (acresToBuy < 0 || acresToBuy * price > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      acresToBuy = readInt("How many acres will you buy? ")
    }
    acresToBuy
  }

  def askHowMuchLandToSell(owned: Int): Int = {
    var acresToSell = readInt("How many acres will you sell? ")
    while (acresToSell < 0 || acresToSell > owned) {
      println("O Great Hammurabi, we have but " + owned + " acres of land!")
      acresToSell = readInt("How many acres will you sell? ")
    }
    acresToSell
  }

  def askHowMuchGrainToFeed(bushels: Int, population: Int): Int = {
    var grainToFeed = readInt("How much grain will you feed the people? ")
    while (grainToFeed < 0 || grainToFeed > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      grainToFeed = readInt("How much grain will you feed the people? ")
    }
    grainToFeed
  }

  def askHowMuchSeedToPlant(bushels: Int, acres: Int): Int = {
    var seedToPlant = readInt("How many acres will you plant with seed? ")
    while (seedToPlant < 0 || seedToPlant > acres || seedToPlant > bushels) {
      println("O Great Hammurabi, we have but " + bushels +
                " bushels of grain and " + acres + " acres of land!")
      seedToPlant = readInt("How many acres will you plant with seed? ")
    }
    seedToPlant
  }

  def doesPlagueOccur(): Boolean = {
    if (Random.nextInt(100) < 15) true else false
  }

  def hammurabi() {
    var starved = 0
    var immigrants = 5
    var population = 100
    var harvest = 3000
    var bushelsPerAcre = 3
    var rats_ate = 200
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19
    var plagueDeaths = 0

    printIntroductoryMessage()

    for (i <- 1 to 10) {
      println("O great Hammurabi!")
      println("You are in year " + i + " of your ten year rule.")
      println("In the previous year " + starved + " people starved to death.")
      println("In the previous year " + immigrants + " people entered the kingdom.")
      println("The population is now " + population + ".")
      println("We harvested " + harvest + " bushels at " + bushelsPerAcre + " bushels per acre.")
      println("Rats destroyed " + rats_ate + " bushels, leaving " + bushelsInStorage + " bushels in storage.")
      println("The city owns " + acresOwned + " acres of land.")
      println("Land is currently worth " + pricePerAcre + " bushels per acre.")
      println("There were " + plagueDeaths + " deaths from the plague.")
      println("")
      var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      acresOwned += acresToBuy
      bushelsInStorage -= acresToBuy * pricePerAcre
      println("")
      if (acresToBuy == 0) {
        var acresToSell = askHowMuchLandToSell(acresOwned)
        acresOwned -= acresToSell
        bushelsInStorage += acresToSell * pricePerAcre
        println("")
      }
      var grainToFeed = askHowMuchGrainToFeed(bushelsInStorage, population)
      bushelsInStorage -= grainToFeed
      println("")
      var seedToPlant = askHowMuchSeedToPlant(bushelsInStorage, acresOwned)
      bushelsInStorage -= seedToPlant
      println("")
      println("")
      if(doesPlagueOccur()) {
        population /= 2
        println("O great Hammurabi, there has been a plague! Half of your people have died.")
      }
    }
  }

}


