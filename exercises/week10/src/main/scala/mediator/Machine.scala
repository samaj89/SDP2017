package mediator

class Machine extends Colleague {

  private var mediator: MachineMediator = _

  override def setMediator(mediator: MachineMediator): Unit = {
    this.mediator = mediator
  }

  def start(): Unit = {
    mediator.open()
    mediator.closed()
    mediator.on()
    mediator.checkTemperature(0)
    mediator.off()
    wash()
  }

  def wash(): Unit = mediator.wash()
}