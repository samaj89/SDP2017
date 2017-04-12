package command

class SmsJob extends Job {
  var thisSms: Sms = null

  def setSms(sms: Sms): Unit = {
    thisSms = sms
  }

  override def run(): Unit = thisSms.sendSms
}