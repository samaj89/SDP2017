package xpay

class XpayToPayDAdapter(xpayObject: Xpay) extends PayD {
  override def getCustCardNo: String = xpayObject.getCreditCardNo

  override def setCustCardNo(custCardNo: String) = xpayObject.setCreditCardNo(custCardNo)

  override def getCardOwnerName: String = xpayObject.getCustomerName

  override def setCardOwnerName(cardOwnerName: String) = xpayObject.setCustomerName(cardOwnerName)

  override def getCardExpMonthDate: String = xpayObject.getCardExpMonth + " " + xpayObject.getCardExpYear

  override def setCardExpMonthDate(cardExpMonthDate: String) = {
    val date = cardExpMonthDate.split(" ")
    xpayObject.setCardExpMonth(date(0))
    xpayObject.setCardExpYear(date(1))
  }

  override def getCVVNo: Integer = xpayObject.getCardCVVNo.toInt

  override def setCVVNo(cVVNo: Integer) = xpayObject.setCardCVVNo(cVVNo.toShort)

  override def getTotalAmount: Double = xpayObject.getAmount

  override def setTotalAmount(totalAmount: Double) = xpayObject.setAmount(totalAmount)
}
