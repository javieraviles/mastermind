package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.StartControllerImpl;

public class StartDispatcher extends Dispatcher {

	public StartDispatcher(StartControllerImpl startControllerImpl) {
		super(startControllerImpl);
	}

	@Override
	public void dispatch() {
		((StartControllerImpl) this.acceptorController).start();
	}

}
