package urjc.es.mastermind.models;

import java.util.List;

public class Session {

	private final State state;
	private final Game game;

	public Session() {
		this.state = new State();
		this.game = new Game();
	}

	public void resume() {
		this.game.clear();
		this.state.reset();
	}

	public void next() {
		this.state.next();
	}

	public StateValue getStateValue() {
		return this.state.getValueState();
	}

	public int getGameRowLength() {
		return this.game.getRowLength();
	}

	public void addProposedCombination(List<Color> colors) {
		this.game.addProposedCombination(colors);
	}

	public int getAttempts() {
		return this.game.getAttempts();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}

	public List<Color> getColors(int position) {
		return this.game.getColors(position);
	}

	public int getBlacks(int position) {
		return this.game.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.game.getWhites(position);
	}

}
