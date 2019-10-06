package urjc.es.mastermind.models;

import urjc.es.mastermind.utils.WithConsoleView;

public class Result extends WithConsoleView {

	private int blacks = 0;
	private int whites = 0;

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	int getBlacks() {
		return this.blacks;
	}

	int getWhites() {
		return this.whites;
	}

	boolean isWinner() {
		return Combination.getRowLength() == this.blacks;
	}

}
