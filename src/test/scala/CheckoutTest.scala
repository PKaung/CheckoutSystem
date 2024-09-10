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
    assert(checkout.totalCost(List("Apple","Apple","Orange")) == BigDecimal(0.85))
  }

  test("Buy one, get one free on apples should apply correctly"){
    val checkout = new Checkout()
    assert(checkout.totalCost(List("Apple","Apple")) == BigDecimal(0.60))
  }

  test("3 for the price of 2 on oranges should apply correctly"){
    val checkout = new Checkout()
    assert(checkout.totalCost(List("Orange","Orange","Orange")) == BigDecimal(0.50))
  }

  test("Cart with 2 apples and 3 oranges should apply offers and return £1.10"){
    val cart = List("Apple","Apple","Orange","Orange","Orange")
    val checkout = new Checkout()
    assert(checkout.totalCost(cart) == BigDecimal(1.10))
  }

  test("Total cost should ignore invalid items"){
    val checkout = new Checkout()
    assert(checkout.totalCost(List("Apple","Banana","Orange")) == BigDecimal(0.85))
  }
}
