package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.InGameController;

class PlayView {

	void interact(InGameController inGameController) {
		new PlayMenu(inGameController).execute();
	}

}
