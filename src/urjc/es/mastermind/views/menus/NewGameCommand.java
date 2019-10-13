package urjc.es.mastermind.views.menus;

import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.views.MessageView;

class NewGameCommand extends Command {

	protected NewGameCommand(StartController startController) {
		super(MessageView.NEWGAME_COMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		((StartController) this.acceptorController).start();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}