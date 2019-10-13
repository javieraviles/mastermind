package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.SaveControllerImpl;

public class SaveDispatcher extends Dispatcher {

	public SaveDispatcher(SaveControllerImpl saveControllerImpl) {
		super(saveControllerImpl);
	}

	@Override
	public void dispatch() {
		String name = this.tcpip.receiveLine();
		((SaveControllerImpl) this.acceptorController).save(name);
	}

}
