package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.utils.Menu;

class PlayMenu extends Menu {

	PlayMenu(InGameController inGameController) {
		this.addCommand(new ProposeCommand(inGameController));
		this.addCommand(new UndoCommand(inGameController));
		this.addCommand(new RedoCommand(inGameController));
	}

}