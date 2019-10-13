package urjc.es.mastermind.controllers.implementation;

import urjc.es.mastermind.controllers.Logic;
import urjc.es.mastermind.models.SessionImpl;
import urjc.es.mastermind.models.StateValue;
import urjc.es.mastermind.models.DAO.SessionImplDAO;

public class LogicImpl extends Logic {

	protected StartControllerImpl startControllerImpl;
	protected InGameControllerImpl inGameControllerImpl;
	protected ResumeControllerImpl resumeControllerImpl;
	protected SaveControllerImpl saveControllerImpl;

	public LogicImpl() {
		this.session = new SessionImpl();
		SessionImplDAO sessionImplDAO = new SessionImplDAO((SessionImpl) this.session);
		this.startControllerImpl = new StartControllerImpl(this.session, sessionImplDAO);
		this.inGameControllerImpl = new InGameControllerImpl(this.session);
		this.resumeControllerImpl = new ResumeControllerImpl(this.session);
		this.saveControllerImpl = new SaveControllerImpl(this.session, sessionImplDAO);
		this.controllers.put(StateValue.INITIAL, this.startControllerImpl);
		this.controllers.put(StateValue.IN_GAME, this.inGameControllerImpl);
		this.controllers.put(StateValue.FINAL, this.resumeControllerImpl);
		this.controllers.put(StateValue.EXIT, null);
		this.controllers.put(StateValue.SAVING, this.saveControllerImpl);
	}

}
