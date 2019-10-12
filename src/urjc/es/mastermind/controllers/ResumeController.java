package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;

public class ResumeController extends AcceptorController {

	public ResumeController(Session session) {
		super(session);
	}

	public void resume(boolean newGame) {
		if (newGame) {
			this.session.clearGame();
		} else {
			this.session.next();
		}
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
