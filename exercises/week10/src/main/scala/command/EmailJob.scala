package command

class EmailJob extends Job {
  var thisEmail: Email = null

  def setEmail(email: Email): Unit = {
    thisEmail = email
  }

  override def run(): Unit = thisEmail.sendEmail()
}