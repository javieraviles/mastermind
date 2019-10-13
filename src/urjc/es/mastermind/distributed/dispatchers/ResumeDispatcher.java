package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.ResumeControllerImpl;

public class ResumeDispatcher extends Dispatcher {

	public ResumeDispatcher(ResumeControllerImpl resumeControllerImpl) {
		super(resumeControllerImpl);
	}

	@Override
	public void dispatch() {
		boolean newGame = this.tcpip.receiveBoolean();
		((ResumeControllerImpl) this.acceptorController).resume(newGame);
	}

}