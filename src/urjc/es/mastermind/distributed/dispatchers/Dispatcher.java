package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.AcceptorController;

public abstract class Dispatcher {
	protected AcceptorController acceptorController;

	protected TCPIP tcpip;

	public Dispatcher(AcceptorController acceptorController) {
		this.acceptorController = acceptorController;
	}

	public abstract void dispatch();

	public void associate(TCPIP tcpip) {
		this.tcpip = tcpip;
	}

}
