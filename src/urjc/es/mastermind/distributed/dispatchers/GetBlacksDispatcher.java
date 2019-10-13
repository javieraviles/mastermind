package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.InGameControllerImpl;

public class GetBlacksDispatcher extends Dispatcher {

	public GetBlacksDispatcher(InGameControllerImpl inGameControllerImpl) {
		super(inGameControllerImpl);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		this.tcpip.send(((InGameControllerImpl) this.acceptorController).getBlacks(position));
	}

}