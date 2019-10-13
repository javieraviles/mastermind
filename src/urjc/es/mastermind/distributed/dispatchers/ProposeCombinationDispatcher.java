package urjc.es.mastermind.distributed.dispatchers;

import java.util.ArrayList;
import java.util.List;

import urjc.es.mastermind.controllers.implementation.InGameControllerImpl;
import urjc.es.mastermind.models.Color;

public class ProposeCombinationDispatcher extends Dispatcher {

	public ProposeCombinationDispatcher(InGameControllerImpl inGameControllerImpl) {
		super(inGameControllerImpl);
	}
	
	@Override
	public void dispatch() {
		int length = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<length; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		this.tcpip.send(((InGameControllerImpl) this.acceptorController).addProposedCombination(colors));
	}

}
