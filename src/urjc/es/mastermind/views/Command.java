package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.InGameController;

abstract class Command extends urjc.es.mastermind.utils.Command {

	protected InGameController inGameController;

	protected Command(String title, InGameController inGameController) {
		super(title);
		this.inGameController = inGameController;
	}
}
