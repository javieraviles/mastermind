package urjc.es.mastermind.views.menus;

import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.utils.Menu;

public class StartMenu extends Menu {

	public StartMenu(StartController startController) {
		this.addCommand(new NewGameCommand(startController));
		this.addCommand(new OpenGameCommand(startController));
	}
}