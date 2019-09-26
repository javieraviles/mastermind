package urjc.es.mastermind.types;

public class GameConfig {

	private int maxAttempts;
	private int rowLength;

	public GameConfig(final int maxAttempts, final int rowLength) {
		super();
		this.maxAttempts = maxAttempts;
		this.rowLength = rowLength;
	}

	public int getMaxAttempts() {
		return maxAttempts;
	}

	public int getRowLength() {
		return rowLength;
	}

}
