package urjc.es.mastermind.distributed;

import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.distributed.dispatchers.FrameType;
import urjc.es.mastermind.distributed.dispatchers.TCPIP;
import urjc.es.mastermind.models.Session;

public class StartControllerProxy extends StartController {
	private TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void start() {
		this.tcpip.send(FrameType.START.name());
	}
}
