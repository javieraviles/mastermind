package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.Controller;
import urjc.es.mastermind.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {

	private Controller controller;

	SecretCombinationView(Controller controller) {
		super();
		this.controller = controller;
	}

	void writeln() {
		for (int i = 0; i < this.controller.getRowLength(); i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}

}