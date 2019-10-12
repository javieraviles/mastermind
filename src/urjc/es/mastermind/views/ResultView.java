package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.InGameController;

class ResultView {

	private InGameController inGameController;

	ResultView(InGameController inGameController) {
		this.inGameController = inGameController;
	}

	void writeln(int position) {
		MessageView.RESULT.writeln(this.inGameController.getBlacks(position),
				this.inGameController.getWhites(position));
		;
	}

}
