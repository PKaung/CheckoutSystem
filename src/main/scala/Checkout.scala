class Checkout {
  def totalCost(items: List[String]): BigDecimal = {
    val prices = Map("Apple" -> BigDecimal(0.60), "Orange" -> BigDecimal(0.25))

    val apples = items.count(_ == "Apple")
    val oranges = items.count(_ == "Orange")

    val appleTotalPrices = (apples/2 + apples % 2) * prices("Apple").setScale(2,BigDecimal.RoundingMode.HALF_UP)
    val orangeTotalPrices = oranges * prices("Orange").setScale(2,BigDecimal.RoundingMode.HALF_UP)

    (appleTotalPrices+orangeTotalPrices).setScale(2,BigDecimal.RoundingMode.HALF_UP)
  }
}
