package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.InGameController;

class RedoCommand extends Command{
	
	RedoCommand(InGameController inGameController) {
		super(MessageView.REDO_COMMAND.getMessage(), inGameController);
	}

	@Override
	protected void execute() {
		this.inGameController.redo();
		new GameView(this.inGameController);
	}

	@Override
	protected boolean isActive() {
		return this.inGameController.redoable();
	}

}