package urjc.es.mastermind.views;

import urjc.es.mastermind.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {

	public ProposedCombinationView() {
	}

	public void writeln(final String message) {
		this.console.writeln(message);
	}

	public String read() {
		return this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
	}

}
