package urjc.es.mastermind.controllers.implementation;

import urjc.es.mastermind.controllers.SaveController;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.SessionImpl;
import urjc.es.mastermind.models.DAO.SessionImplDAO;

public class SaveControllerImpl extends SaveController {

	private final SessionImplDAO sessionImplDAO;

	SaveControllerImpl(Session session, SessionImplDAO sessionImplDAO) {
		super(session);
		this.sessionImplDAO = sessionImplDAO;
	}

	@Override
	public void save(String name) {
		this.sessionImplDAO.save(name);
	}

	@Override
	public void save() {
		this.sessionImplDAO.save();
	}

	@Override
	public void next() {
		((SessionImpl) this.session).next();
	}

	@Override
	public boolean hasName() {
		return ((SessionImpl) this.session).hasName();
	}

	@Override
	public boolean exists(String name) {
		return this.sessionImplDAO.exists(name);
	}

}
