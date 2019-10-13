package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.SessionImpl;

public class RedoController extends Controller {

	public RedoController(Session session) {
		super(session);
	}

	public void redo() {
		((SessionImpl) this.session).redo();
	}

	public boolean redoable() {
		return ((SessionImpl) this.session).redoable();
	}

}
