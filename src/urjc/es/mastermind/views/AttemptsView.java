package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	private InGameController inGameController;

	AttemptsView(InGameController inGameController) {
		this.inGameController = inGameController;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.inGameController.getAttempts());
	}

}
