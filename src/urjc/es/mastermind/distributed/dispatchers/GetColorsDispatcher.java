package urjc.es.mastermind.distributed.dispatchers;

import java.util.List;

import urjc.es.mastermind.controllers.implementation.InGameControllerImpl;
import urjc.es.mastermind.models.Color;

public class GetColorsDispatcher extends Dispatcher {

	public GetColorsDispatcher(InGameControllerImpl inGameControllerImpl) {
		super(inGameControllerImpl);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		List<Color> colors = ((InGameControllerImpl) this.acceptorController).getColors(position);
		this.tcpip.send(colors.size());
		for (Color color : colors) {
			this.tcpip.send(color);
		}
	}

}
