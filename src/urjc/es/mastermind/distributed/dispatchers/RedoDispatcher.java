package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.InGameControllerImpl;

public class RedoDispatcher extends Dispatcher {

	public RedoDispatcher(InGameControllerImpl inGameControllerImpl) {
		super(inGameControllerImpl);
	}

	@Override
	public void dispatch() {
		((InGameControllerImpl) this.acceptorController).redo();
	}

}
