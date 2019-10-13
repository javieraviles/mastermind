package urjc.es.mastermind.distributed;

import urjc.es.mastermind.distributed.dispatchers.FrameType;
import urjc.es.mastermind.distributed.dispatchers.TCPIP;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.StateValue;

public class SessionProxy implements Session {

	private final TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}

	public int getWidth() {
		this.tcpip.send(FrameType.GETWIDTH.name());
		return this.tcpip.receiveInt();
	}

	public StateValue getValueState() {
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

	public String getName() {
		this.tcpip.send(FrameType.GETTITLE.name());
		return this.tcpip.receiveLine();
	}

	public void setName(String title) {
		this.tcpip.send(FrameType.SETTITLE.name());
		this.tcpip.send(title);
	}

}
