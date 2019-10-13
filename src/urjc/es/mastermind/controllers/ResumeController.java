package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;

public abstract class ResumeController extends AcceptorController {

	public ResumeController(Session session) {
		super(session);
	}

	public abstract void resume(boolean newGame);

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
