package urjc.es.mastermind.views.menus;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.views.GameView;
import urjc.es.mastermind.views.MessageView;

public class UndoCommand extends Command {

	UndoCommand(InGameController inGameController) {
		super(MessageView.UNDO_COMMAND.getMessage(), inGameController);
	}

	@Override
	protected void execute() {
		((InGameController) this.acceptorController).undo();
		new GameView((InGameController) this.acceptorController);
	}

	@Override
	protected boolean isActive() {
		return ((InGameController) this.acceptorController).undoable();
	}
}
