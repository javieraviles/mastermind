package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.SaveControllerImpl;

public class HasNameDispatcher extends Dispatcher {

	public HasNameDispatcher(SaveControllerImpl saveControllerImpl) {
		super(saveControllerImpl);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((SaveControllerImpl) this.acceptorController).hasName());
	}

}