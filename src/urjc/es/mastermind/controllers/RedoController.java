package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;

public class RedoController extends Controller {

	public RedoController(Session session) {
		super(session);
	}

	void redo() {
		this.session.redo();
	}

	boolean redoable() {
		return this.session.redoable();
	}

}
