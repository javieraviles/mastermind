package urjc.es.mastermind;

import urjc.es.mastermind.controllers.Controller;
import urjc.es.mastermind.controllers.Logic;
import urjc.es.mastermind.views.ConsoleView;
import urjc.es.mastermind.views.View;

public class Mastermind {

	private Logic logic;
	private View view;

	protected Mastermind() {
		this.logic = new Logic();
		this.view = new ConsoleView();
	}

	protected void play() {
		Controller controller;
		do {
			controller = this.logic.getController();
			if (controller != null) {
				this.view.interact(controller);
			}
		} while (controller != null);
	}
	
	public static void main(String[] args) {
		new Mastermind().play();
	}

}
