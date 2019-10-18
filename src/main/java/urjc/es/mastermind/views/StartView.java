package urjc.es.mastermind.views;

import urjc.es.mastermind.utils.WithConsoleView;

public class StartView extends WithConsoleView {

	public StartView() {
	}

	public void writeGameIntro() {
		this.console.writeln(MessageView.TITLE.getMessage());
	}

}
