package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.InGameController;

public class GameView {
	
	GameView(InGameController inGameController) {
		MessageView.NEW_LINE.writeln();
		new AttemptsView(inGameController).writeln();
		new SecretCombinationView(inGameController).writeln();
		for (int i = 0; i < inGameController.getAttempts(); i++) {
			new ProposedCombinationView(inGameController).write(i);
			new ResultView(inGameController).writeln(i);
		}
		if (inGameController.isWinner()) {
			MessageView.WINNER.writeln();
		} else if (inGameController.isLooser()) {
			MessageView.LOOSER.writeln();
		}
	}
	
}
