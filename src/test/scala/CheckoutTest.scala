import org.scalatest.funsuite.AnyFunSuite

class CheckoutTest  extends AnyFunSuite {
  test("Total cost of an empty cart should be £0.00"){
    val checkout = new Checkout()
    assert(checkout.totalCost(List.empty) == BigDecimal(0.00))
  }

  test("Total cost of apples and oranges should be calculated correctly"){
    val checkout = new Checkout()
    assert(checkout.totalCost(List("Apple","Orange")) == BigDecimal(0.85))
  }

  test("Total cost of multiple apples and oranges should be calculated correctly"){
    val checkout = new Checkout()
    assert(checkout.totalCost(List("Apple","Apple","Orange")) == BigDecimal(1.45))
  }
}
