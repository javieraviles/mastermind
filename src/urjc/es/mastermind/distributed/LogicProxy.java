package urjc.es.mastermind.distributed;

import urjc.es.mastermind.controllers.Logic;
import urjc.es.mastermind.distributed.dispatchers.TCPIP;
import urjc.es.mastermind.models.StateValue;

public class LogicProxy extends Logic {

	private TCPIP tcpip;

	public LogicProxy() {
		this.tcpip = TCPIP.createClientSocket();
		this.session = new SessionProxy(this.tcpip);
		this.controllers.put(StateValue.INITIAL, new StartControllerProxy(this.session, this.tcpip));
		this.controllers.put(StateValue.IN_GAME, new InGameControllerProxy(this.session, this.tcpip));
		this.controllers.put(StateValue.FINAL, new ResumeControllerProxy(this.session, this.tcpip));
		this.controllers.put(StateValue.EXIT, null);
        this.controllers.put(StateValue.SAVING, new SaveControllerProxy(this.session, this.tcpip));
	}
	
	public void close() {
        this.tcpip.close();
    }

}