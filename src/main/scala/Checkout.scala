class Checkout {

  private val applePrice = BigDecimal(0.60)
  private val orangePrice = BigDecimal(0.25)
  def totalCost(items: List[String]): BigDecimal = {

    val apples = countItems(items,"Apple")
    val oranges = countItems(items, "Orange")

    val appleTotalPrices = calculateAppleTotalPrice(apples)
    val orangeTotalPrices = calculateOrangeTotalPrice(oranges)

    (appleTotalPrices+orangeTotalPrices).setScale(2,BigDecimal.RoundingMode.HALF_UP)
  }

  private def calculateAppleTotalPrice(apples: Int): BigDecimal = {
    (apples / 2 + apples % 2) * applePrice.setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }

  private def calculateOrangeTotalPrice(oranges: Int): BigDecimal = {
    ((oranges / 3) * 2 + oranges % 3)  * orangePrice.setScale(2,BigDecimal.RoundingMode.HALF_UP)
  }

  private def countItems(items: List[String], item: String): Int = {
    items.count(_ == item)
  }
}
