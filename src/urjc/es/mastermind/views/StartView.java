package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.views.menus.StartMenu;

class StartView {

	void interact(StartController startController) {
		MessageView.TITLE.writeln();
		new StartMenu(startController).execute();
	}

}
