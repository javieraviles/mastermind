package urjc.es.mastermind.models;

import urjc.es.mastermind.utils.WithConsoleView;

public class Result extends WithConsoleView {

	private int blacks = 0;
	private int whites = 0;

	public Result() {
	}

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	public int getBlacks() {
		return this.blacks;
	}

	public int getWhites() {
		return this.whites;
	}

	public void setBlacks(int blacks) {
		this.blacks = blacks;
	}

	public void setWhites(int whites) {
		this.whites = whites;
	}

	boolean isWinner() {
		return Combination.getWidth() == this.blacks;
	}

	Result copy() {
		return new Result(this.blacks, this.whites);
	}

}
