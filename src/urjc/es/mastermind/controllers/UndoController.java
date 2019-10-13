package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.SessionImpl;

public class UndoController extends Controller {

	public UndoController(Session session) {
		super(session);
	}

	public void undo() {
		((SessionImpl) this.session).undo();
	}

	public boolean undoable() {
		return ((SessionImpl) this.session).undoable();
	}

}
