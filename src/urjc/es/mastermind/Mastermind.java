package urjc.es.mastermind;

import urjc.es.mastermind.controllers.AcceptorController;
import urjc.es.mastermind.controllers.Logic;
import urjc.es.mastermind.views.View;

public abstract class Mastermind {

	private Logic logic;
	private View view;

	protected Mastermind() {
		this.logic = this.createLogic();
		this.view = new View();
	}

	protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null) {
				this.view.interact(acceptorController);
			}
		} while (acceptorController != null);
	}

	protected abstract Logic createLogic();

}
