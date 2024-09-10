class Checkout {
  def totalCost(items: List[String]): BigDecimal = {
    val prices = Map("Apple" -> BigDecimal(0.60), "Orange" -> BigDecimal(0.25))
    items.map(prices).sum.setScale(2,BigDecimal.RoundingMode.HALF_UP)
  }
}
