package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.SaveControllerImpl;

public class GetTitleDispatcher extends Dispatcher {

	public GetTitleDispatcher(SaveControllerImpl saveControllerImpl) {
		super(saveControllerImpl);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(this.acceptorController.getName());
	}

}
