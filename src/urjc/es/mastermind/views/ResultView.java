package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.ProposalController;
import urjc.es.mastermind.utils.WithConsoleView;

class ResultView extends WithConsoleView {
	
	private ProposalController proposalController;
	
	ResultView(ProposalController proposalController){
		this.proposalController = proposalController;
	}

	void writeln(int i) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.proposalController.getBlacks(i))
				.replaceFirst("#whites", "" + this.proposalController.getWhites(i)));
	}

}
