package urjc.es.mastermind.controllers.implementation;

import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.SessionImpl;
import urjc.es.mastermind.models.DAO.SessionImplDAO;

public class StartControllerImpl extends StartController {

	private final SessionImplDAO sessionImplDAO;

	public StartControllerImpl(Session session, SessionImplDAO sessionImplDAO) {
		super(session);
		this.sessionImplDAO = sessionImplDAO;
	}

	@Override
	public void start(String name) {
		this.sessionImplDAO.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionImplDAO.getGamesNames();
	}

	@Override
	public void start() {
		((SessionImpl) this.session).next();
	}
}
