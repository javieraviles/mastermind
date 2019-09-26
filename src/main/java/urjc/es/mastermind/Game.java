package urjc.es.mastermind;

import static urjc.es.mastermind.utils.MessageDialogs.ATTEMPT_SEPARATOR;
import static urjc.es.mastermind.utils.MessageDialogs.ATTEMPT_TAG;
import static urjc.es.mastermind.utils.MessageDialogs.GAME_TITLE;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_CONTINUE_PLAYING;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_PROPOSAL;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_LOSE;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_WIN;

import java.util.List;
import java.util.Map;

import urjc.es.mastermind.enums.CodePeg;
import urjc.es.mastermind.enums.KeyPeg;
import urjc.es.mastermind.utils.Utils;

public class Game {

	private int maxAttempts;
	private int rowLength;

	public Game(final int maxAttempts, final int rowLength) {
		this.maxAttempts = maxAttempts;
		this.rowLength = rowLength;
	}

	public void start() {

		final DecodingBoard decodingBoard = new DecodingBoard();
		final CodeMaker codeMaker = new CodeMaker(rowLength);
		final CodeBreaker codeBreaker = new CodeBreaker();
		String guess = "";
		
		do {
			decodingBoard.clear();
			codeMaker.generatePattern();

			System.out.println(GAME_TITLE);

			for (int i = 1; i <= maxAttempts; i++) {
				System.out.println(ATTEMPT_SEPARATOR);
				System.out.println(MSG_GUESS_PROPOSAL);

				guess = generateValidGuess(codeBreaker);

				System.out.println(i + ATTEMPT_TAG);

				// check guess against pattern and give feedback to code breaker
				final List<CodePeg> guessAsList = Utils.convertGuessToCodePegList(guess);
				final Map<KeyPeg, Integer> guessFeedback = codeMaker.compareGuessWithPattern(guessAsList);
				decodingBoard.fillRow(Utils.formatFeedback(guess, guessFeedback));
				decodingBoard.printDecodingBoard();

				// check whether the user has already won or lost
				if (isWinner(guessFeedback)) {
					System.out.println(MSG_WIN);
					break;
				} else if (isLooser(i)) {
					System.out.println(MSG_LOSE);
				}
			}
			System.out.print(MSG_CONTINUE_PLAYING);

		} while (codeBreaker.askToPlayAgain());
	}

	// ask the code breaker to insert a guess until complies with rules
	private String generateValidGuess(final CodeBreaker codeBreaker) {
		String guess;
		String guessError = "";
		do {
			if (!guessError.isEmpty()) {
				System.out.println(guessError);
			}
			guess = codeBreaker.introduceGuess();
			guessError = Utils.validateGuess(guess, rowLength);
		} while (!guessError.isEmpty());
		return guess;
	}
	
	private boolean isWinner(final Map<KeyPeg, Integer> guessFeedback) {
		return guessFeedback.get(KeyPeg.b) == rowLength;
	}
	
	private boolean isLooser(final int numberOfAttempts) {
		return numberOfAttempts == maxAttempts;
	}

}
