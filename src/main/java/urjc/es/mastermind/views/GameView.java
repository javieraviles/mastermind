package urjc.es.mastermind.views;

import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.utils.WithConsoleView;

public class GameView extends WithConsoleView {

	public GameView() {
	}

	public void writeGame(Session session) {
		new AttemptsView().writeln(session.getAttempts());
		new SecretCombinationView().writeln(session.getGameRowLength());
		for (int i = 0; i < session.getAttempts(); i++) {
			this.writeColors(i, session);
		}
	}

	private void writeColors(int position, Session session) {
		for (Color color : session.getColors(position)) {
			new ColorView(color).write();
		}
		new ResultView().writeln(session.getBlacks(position), session.getWhites(position));
	}
}
