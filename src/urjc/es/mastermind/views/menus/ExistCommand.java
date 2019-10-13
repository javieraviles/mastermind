package urjc.es.mastermind.views.menus;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.views.MessageView;

class ExitCommand extends Command {

	protected ExitCommand(InGameController inGameController) {
		super(MessageView.EXIT_COMMAND.getMessage(), inGameController);
	}

	@Override
	protected void execute() {
		((InGameController) this.acceptorController).next();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
