package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.StartControllerImpl;

public class StartNameDispatcher extends Dispatcher {

	public StartNameDispatcher(StartControllerImpl startControllerImpl) {
		super(startControllerImpl);
	}

	@Override
	public void dispatch() {
		String title = this.tcpip.receiveLine();
		((StartControllerImpl) this.acceptorController).start(title);
	}

}