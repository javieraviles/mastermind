package urjc.es.mastermind.views;

import urjc.es.mastermind.utils.WithConsoleView;

public class SecretCombinationView extends WithConsoleView {

	public SecretCombinationView() {
	}

	public void writeln(final int width) {
		for (int i = 0; i < width; i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}

}