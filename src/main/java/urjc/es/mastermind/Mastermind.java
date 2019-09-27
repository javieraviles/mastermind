package urjc.es.mastermind;

import urjc.es.mastermind.models.Game;
import urjc.es.mastermind.types.GameConfig;

public class Mastermind {
	private static final int ROW_LENGTH = 4;
	private static final int MAX_ATTEMPTS = 10;

	public static void main(String[] args) {

		final GameConfig gameConfig = new GameConfig(MAX_ATTEMPTS, ROW_LENGTH);

		new Game(gameConfig).start();
	}
}
