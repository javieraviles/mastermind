package urjc.es.mastermind;

import urjc.es.mastermind.controllers.AcceptorController;
import urjc.es.mastermind.controllers.Controller;
import urjc.es.mastermind.controllers.Logic;
import urjc.es.mastermind.views.View;

public class Mastermind {

	private Logic logic;
	private View view;

	protected Mastermind() {
		this.logic = new Logic();
		this.view = new View();
	}

	protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null){
				this.view.interact(acceptorController);
			}
		} while (acceptorController != null); 
	}
	
	public static void main(String[] args) {
		new Mastermind().play();
	}

}
