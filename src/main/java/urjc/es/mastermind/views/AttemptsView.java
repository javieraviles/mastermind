package urjc.es.mastermind.views;

import urjc.es.mastermind.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	public AttemptsView() {
	}

	void writeln(final int attempts) {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + attempts));
	}

}
