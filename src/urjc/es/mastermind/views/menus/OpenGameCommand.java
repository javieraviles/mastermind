package urjc.es.mastermind.views.menus;

import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.views.MessageView;

class OpenGameCommand extends Command {

	protected OpenGameCommand(StartController startController) {
		super(MessageView.OPENGAME_COMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.acceptorController).execute();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}