package urjc.es.mastermind.controllers.implementation;

import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.SessionImpl;

public class StartControllerImpl extends StartController {

	public StartControllerImpl(Session session) {
		super(session);
	}

	@Override
	public void start() {
		((SessionImpl) this.session).next();
	}
}