package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.SaveControllerImpl;

public class SetTitleDispatcher extends Dispatcher {

	public SetTitleDispatcher(SaveControllerImpl saveControllerImpl) {
		super(saveControllerImpl);
	}

	@Override
	public void dispatch() {
		String title = this.tcpip.receiveLine();
		this.acceptorController.setName(title);
	}

}
