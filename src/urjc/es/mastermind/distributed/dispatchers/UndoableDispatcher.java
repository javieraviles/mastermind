package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.InGameControllerImpl;

public class UndoableDispatcher extends Dispatcher {

	public UndoableDispatcher(InGameControllerImpl inGameControllerImpl) {
		super(inGameControllerImpl);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((InGameControllerImpl) this.acceptorController).undoable());
	}

}
