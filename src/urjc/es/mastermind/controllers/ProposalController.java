package urjc.es.mastermind.controllers;

import java.util.List;

import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Combination;
import urjc.es.mastermind.models.Error;
import urjc.es.mastermind.models.Session;

public class ProposalController extends Controller {

	ProposalController(Session session) {
		super(session);
	}

	public Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
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
			if (this.session.isWinner() || this.session.isLooser()) {
				this.session.next();
			}
		}
		return error;
	}

	public int getAttempts() {
		return this.session.getAttempts();
	}

	public boolean isLooser() {
		return this.session.isLooser();
	}

	public boolean isWinner() {
		return this.session.isWinner();
	}

	public int getBlacks(int position) {
		return this.session.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.session.getWhites(position);
	}

	public List<Color> getColors(int position) {
		return this.session.getColors(position);
	}

}
