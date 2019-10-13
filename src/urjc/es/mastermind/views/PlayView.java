package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.views.menus.PlayMenu;

class PlayView {

	void interact(InGameController inGameController) {
		new PlayMenu(inGameController).execute();
		new GameView(inGameController).writeln();
	}

}
