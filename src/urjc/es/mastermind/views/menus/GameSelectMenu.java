package urjc.es.mastermind.views.menus;

import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.utils.Menu;

class GameSelectMenu extends Menu {

	GameSelectMenu(StartController startController) {
		String[] gamesNames = startController.getGamesNames();
		for (String title : gamesNames) {
			this.addCommand(new GameSelectCommand(title, startController));
		}
	}

}