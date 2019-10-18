package urjc.es.mastermind.controllers;

import java.util.ArrayList;
import java.util.List;

import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Combination;
import urjc.es.mastermind.models.Error;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.views.ColorView;
import urjc.es.mastermind.views.ErrorView;
import urjc.es.mastermind.views.GameView;
import urjc.es.mastermind.views.MessageView;
import urjc.es.mastermind.views.ProposedCombinationView;

public class ProposalController extends Controller {

	private final ProposedCombinationView proposedCombinationView;

	public ProposalController(Session session) {
		super(session);
		this.proposedCombinationView = new ProposedCombinationView();
	}

	public void control() {
		Error error;
		do {
			String characters = this.proposedCombinationView.read();
			List<Color> colors = new ArrayList<Color>();
			for (int i = 0; i < characters.length(); i++) {
				colors.add(ColorView.getInstance(characters.charAt(i)));
			}
			error = this.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		this.proposedCombinationView.writeln("");
		new GameView().writeGame(this.session);
		this.checkGameTermination();
	}

	private void checkGameTermination() {
		if (this.session.isWinner()) {
			this.proposedCombinationView.writeln(MessageView.WINNER.getMessage());
			this.session.next();
		} else if (this.session.isLooser()) {
			this.proposedCombinationView.writeln(MessageView.LOOSER.getMessage());
			this.session.next();
		}
	}

	private Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getRowLength()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i + 1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}
			}
		}
		if (error == null) {
			this.session.addProposedCombination(colors);
		}
		return error;
	}

}
