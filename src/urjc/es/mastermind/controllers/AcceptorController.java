package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;

public abstract class AcceptorController extends Controller {

	AcceptorController(Session session) {
		super(session);
	}

	public abstract void accept(ControllerVisitor controllersVisitor);

}