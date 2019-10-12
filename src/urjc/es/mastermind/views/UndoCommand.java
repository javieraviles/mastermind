package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.InGameController;

public class UndoCommand extends Command {

	UndoCommand(InGameController inGameController) {
		super(MessageView.UNDO_COMMAND.getMessage(), inGameController);
	}

	@Override
	protected void execute() {
		this.inGameController.undo();
		new GameView(this.inGameController);
	}

	@Override
	protected boolean isActive() {
		return this.inGameController.undoable();
	}
}
