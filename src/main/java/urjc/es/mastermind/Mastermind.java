package urjc.es.mastermind;

import java.util.HashMap;
import java.util.Map;

import urjc.es.mastermind.controllers.Controller;
import urjc.es.mastermind.controllers.ProposalController;
import urjc.es.mastermind.controllers.ResumeController;
import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.StateValue;

public class Mastermind {

	Session session;
	Map<StateValue, Controller> controllers;

	private Mastermind() {
		this.session = new Session();
		this.controllers = new HashMap<>();
		controllers.put(StateValue.INITIAL, new StartController(session));
		controllers.put(StateValue.IN_GAME, new ProposalController(session));
		controllers.put(StateValue.FINAL, new ResumeController(session));
		controllers.put(StateValue.EXIT, null);
	}

	protected void play() {
		Controller controller;
		do {
			controller = this.controllers.get(this.session.getStateValue());
			if (controller != null) {
				controller.control();
			}
		} while (controller != null);
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
