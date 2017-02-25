package xpay

object TestXpayToPayDAdapter extends App {
  val xpayA = new XpayImpl

  xpayA.setCreditCardNo("4948295736298473")
  xpayA.setCustomerName("Joan Smyth")
  xpayA.setCardExpMonth("February")
  xpayA.setCardExpYear("2019")
  xpayA.setCardCVVNo(175)
  xpayA.setAmount(352.0)

  val xpayAdapter = new XpayToPayDAdapter(xpayA)

  println("Using Xpay interface...")
  println("Credit card no: " + xpayA.getCreditCardNo)
  println("Customer name: " + xpayA.getCustomerName)
  println("Card expiry month: " + xpayA.getCardExpMonth)
  println("Card expiry year: " + xpayA.getCardExpYear)
  println("Card CVV no: " + xpayA.getCardCVVNo)
  println("Amount: " + xpayA.getAmount + "\n")

  println("Using Xpay to PayD adapter...")
  println("Credit card no: " + xpayAdapter.getCustCardNo)
  println("Customer name: " + xpayAdapter.getCardOwnerName)
  println("Card expiry date: " + xpayAdapter.getCardExpMonthDate)
  println("Card CVV no: " + xpayAdapter.getCVVNo)
  println("Amount: " + xpayAdapter.getTotalAmount)
}
