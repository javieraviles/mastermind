package urjc.es.mastermind.views.menus;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.views.GameView;
import urjc.es.mastermind.views.MessageView;

class RedoCommand extends Command {

	RedoCommand(InGameController inGameController) {
		super(MessageView.REDO_COMMAND.getMessage(), inGameController);
	}

	@Override
	protected void execute() {
		((InGameController) this.acceptorController).redo();
		new GameView((InGameController) this.acceptorController);
	}

	@Override
	protected boolean isActive() {
		return ((InGameController) this.acceptorController).redoable();
	}

}