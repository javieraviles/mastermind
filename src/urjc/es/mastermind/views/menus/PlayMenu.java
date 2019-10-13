package urjc.es.mastermind.views.menus;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.utils.Menu;

public class PlayMenu extends Menu {

	public PlayMenu(InGameController inGameController) {
		this.addCommand(new ProposeCommand(inGameController));
		this.addCommand(new UndoCommand(inGameController));
		this.addCommand(new RedoCommand(inGameController));
		this.addCommand(new ExitCommand(inGameController));
	}

}