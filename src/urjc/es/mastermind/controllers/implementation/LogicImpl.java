package urjc.es.mastermind.controllers.implementation;

import urjc.es.mastermind.controllers.Logic;
import urjc.es.mastermind.models.SessionImpl;
import urjc.es.mastermind.models.StateValue;

public class LogicImpl extends Logic {

	protected StartControllerImpl startControllerImpl;
	protected InGameControllerImpl inGameControllerImpl;
	protected ResumeControllerImpl resumeControllerImpl;

	public LogicImpl() {
		this.session = new SessionImpl();
		this.startControllerImpl = new StartControllerImpl(this.session);
		this.inGameControllerImpl = new InGameControllerImpl(this.session);
		this.resumeControllerImpl = new ResumeControllerImpl(this.session);
		this.controllers.put(StateValue.INITIAL, new StartControllerImpl(this.session));
		this.controllers.put(StateValue.IN_GAME, new InGameControllerImpl(this.session));
		this.controllers.put(StateValue.FINAL, new ResumeControllerImpl(this.session));
		this.controllers.put(StateValue.EXIT, null);
	}

}
