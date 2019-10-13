package urjc.es.mastermind.views.menus;

import urjc.es.mastermind.controllers.AcceptorController;

abstract class Command extends urjc.es.mastermind.utils.Command {

	protected AcceptorController acceptorController;

	protected Command(String title, AcceptorController acceptorController) {
		super(title);
		this.acceptorController = acceptorController;
	}
}
