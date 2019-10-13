package urjc.es.mastermind.distributed.dispatchers;

import urjc.es.mastermind.controllers.implementation.StartControllerImpl;

public class TitlesDispatcher extends Dispatcher {

	public TitlesDispatcher(StartControllerImpl startControllerImpl) {
		super(startControllerImpl);
	}

	@Override
	public void dispatch() {
		String[] names = ((StartControllerImpl) this.acceptorController).getGamesNames();
		this.tcpip.send(names.length);
		for (int i = 0; i < names.length; i++) {
			this.tcpip.send(names[i]);
		}
	}

}