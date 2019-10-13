package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;

public abstract class StartController extends AcceptorController {

	public StartController(Session session) {
		super(session);
	}

	public abstract void start();

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
