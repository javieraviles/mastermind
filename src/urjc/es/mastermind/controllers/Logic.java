package urjc.es.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.StateValue;

public abstract class Logic {

	protected Session session;

	protected Map<StateValue, AcceptorController> controllers;

	protected Logic() {
		this.controllers = new HashMap<StateValue, AcceptorController>();
	}

	public AcceptorController getController() {
		return this.controllers.get(this.session.getValueState());
	}
}
