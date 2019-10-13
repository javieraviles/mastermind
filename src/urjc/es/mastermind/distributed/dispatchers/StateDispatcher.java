package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.InGameController;

public class StateDispatcher extends Dispatcher {
	public StateDispatcher(InGameController inGameController) {
		super(inGameController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(this.acceptorController.getValueState().ordinal());
	}

}
