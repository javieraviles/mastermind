package urjc.es.mastermind.controllers;

import java.util.List;

import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Combination;
import urjc.es.mastermind.models.Error;
import urjc.es.mastermind.models.Game;
import urjc.es.mastermind.models.State;

public class ProposalController extends Controller {

	public ProposalController(Game game, State state) {
		super(game, state);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);

	}

	public Error addProposedCombination(List<Color> colors) {
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
			this.game.addProposedCombination(colors);
			if (this.game.isWinner() || this.game.isLooser()) {
				this.state.next();
			}
		}
		return error;
	}

	public int getAttempts() {
		return this.game.getAttempts();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public int getBlacks(int position) {
		return this.game.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.game.getWhites(position);
	}

	public List<Color> getColors(int position) {
		return this.game.getColors(position);
	}

}
