package urjc.es.mastermind.models;

import static urjc.es.mastermind.utils.MessageDialogs.ATTEMPT_SEPARATOR;
import static urjc.es.mastermind.utils.MessageDialogs.ATTEMPT_TAG;
import static urjc.es.mastermind.utils.MessageDialogs.GAME_TITLE;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_CONTINUE_PLAYING;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_PROPOSAL;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_LOSE;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_WIN;

import urjc.es.mastermind.types.GameConfig;
import urjc.es.mastermind.types.Guess;
import urjc.es.mastermind.types.GuessFeedback;

public class Game {

	final GameConfig gameConfig;

	public Game(final GameConfig gameConfig) {
		super();
		this.gameConfig = gameConfig;
	}

	public void start() {

		final DecodingBoard decodingBoard = new DecodingBoard();
		final CodeMaker codeMaker = new CodeMaker(gameConfig.getRowLength());
		final CodeBreaker codeBreaker = new CodeBreaker(gameConfig.getRowLength());

		do {
			decodingBoard.clear();
			codeMaker.generatePattern();

			System.out.println(GAME_TITLE);

			for (int i = 1; i <= gameConfig.getMaxAttempts(); i++) {
				System.out.println(ATTEMPT_SEPARATOR);
				System.out.println(MSG_GUESS_PROPOSAL);

				final Guess guess = codeBreaker.generateValidGuess();

				announceAttempts(i);

				// match guess against pattern and give feedback to code breaker
				final GuessFeedback guessFeedback = codeMaker.compareGuessWithPattern(guess.getValue());
				decodingBoard.fillRow(guessFeedback.formatMessage(guess.getStringValue()));
				decodingBoard.printDecodingBoard();

				// check whether the user has already won or lost
				if (checkIfWinner(guessFeedback.getBlacks())) {
					System.out.println(MSG_WIN);
					break;
				} else if (checkIfLooser(i)) {
					System.out.println(MSG_LOSE);
				}
			}
			System.out.print(MSG_CONTINUE_PLAYING);

		} while (codeBreaker.askToPlayAgain());
	}

	private void announceAttempts(int i) {
		final String[] attemptsMessage = { String.valueOf(i), ATTEMPT_TAG };
		System.out.println(attemptsMessage);
	}

	private boolean checkIfWinner(final int numberOfBlacks) {
		return numberOfBlacks == gameConfig.getRowLength();
	}

	private boolean checkIfLooser(final int numberOfAttempts) {
		return numberOfAttempts == gameConfig.getMaxAttempts();
	}

}
