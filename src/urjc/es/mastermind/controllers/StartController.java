package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;

public class StartController extends AcceptorController {

	public StartController(Session session) {
		super(session);
	}

	public void start() {
		this.session.next();
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
