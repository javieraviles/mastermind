package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.SaveControllerImpl;

public class ExistsDispatcher extends Dispatcher {

	public ExistsDispatcher(SaveControllerImpl saveControllerImpl) {
		super(saveControllerImpl);
	}

	@Override
	public void dispatch() {
		String name = this.tcpip.receiveLine();
		this.tcpip.send(((SaveControllerImpl) this.acceptorController).exists(name));
	}

}
