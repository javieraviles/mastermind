package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.StartController;
import urjc.es.mastermind.utils.WithConsoleView;

class StartView extends WithConsoleView {

	private SecretCombinationView secretCombinationView;

	void interact(StartController startController) {
		startController.start();
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
