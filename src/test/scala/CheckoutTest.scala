import org.scalatest.funsuite.AnyFunSuite

class CheckoutTest  extends AnyFunSuite {
  test("Total cost of an empty cart should be £0.00"){
    val checkout = new Checkout()
    assert(checkout.totalCost(List.empty) == BigDecimal(0.00))
  }
}
