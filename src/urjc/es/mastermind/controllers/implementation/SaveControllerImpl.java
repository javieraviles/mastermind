package urjc.es.mastermind.controllers.implementation;

import urjc.es.mastermind.controllers.SaveController;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.SessionImpl;

public class SaveControllerImpl extends SaveController {

	SaveControllerImpl(Session session) {
		super(session);
	}

	@Override
	public void save(String name) {
		((SessionImpl) this.session).save(name);
	}

	@Override
	public void save() {
		((SessionImpl) this.session).save();
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
		return ((SessionImpl) this.session).exists(name);
	}

}
