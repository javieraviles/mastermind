package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.StateValue;

public abstract class Controller {

	protected Session session;

	Controller(Session session) {
		this.session = session;
	}

	public int getWidth() {
		return this.session.getWidth();
	}

	public StateValue getValueState() {
		return this.session.getValueState();
	}
}
