package urjc.es.mastermind.views;

import java.util.ArrayList;
import java.util.List;

import urjc.es.mastermind.controllers.ProposalController;
import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {

	private ProposalController proposalController;

	ProposedCombinationView(ProposalController proposalController) {
		this.proposalController = proposalController;
	}

	void write(int position) {
		for (Color color : this.proposalController.getColors(position)) {
			new ColorView(color).write();
		}
	}

	List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i = 0; i < characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}

}
