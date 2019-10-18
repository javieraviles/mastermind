package urjc.es.mastermind.views;

import urjc.es.mastermind.utils.WithConsoleView;

class ResultView extends WithConsoleView {

	public ResultView() {
	}

	public void writeln(final int blacks, final int whites) {
		this.console.writeln(MessageView.RESULT.getMessage().replaceFirst("#blacks", "" + blacks)
				.replaceFirst("#whites", "" + whites));
	}

}
