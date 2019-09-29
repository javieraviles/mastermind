package urjc.es.mastermind.models;

import static urjc.es.mastermind.utils.MessageDialogs.GAME_TITLE;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_CONTINUE_PLAYING;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_PROPOSAL;

public class Mastermind {

	private static final int MAX_ATTEMPTS = 10;

	public static void main(String[] args) {
		new Mastermind().play();
	}

	public Mastermind() {
		super();
	}

	public void play() {
		final CodeBreaker codeBreaker = new CodeBreaker(MAX_ATTEMPTS);
		final CodeMaker codeMaker = new CodeMaker(codeBreaker);
		do {
			codeBreaker.prepareForNewGame();
			codeMaker.prepareForNewGame();
			System.out.println(GAME_TITLE);
			codeMaker.writeSecretCombination();
			for (int i = 1; i <= MAX_ATTEMPTS; i++) {
				System.out.println(MSG_GUESS_PROPOSAL);
				codeBreaker.proposeCombination();
				codeBreaker.writeAttempts();
				codeMaker.writeSecretCombination();
				codeMaker.answerProposal();
				codeBreaker.writeProposedCombinations();
				if (codeBreaker.didAlreadyWonOrLost()) {
					break;
				}
			}
			System.out.print(MSG_CONTINUE_PLAYING);
		} while (codeBreaker.askToPlayAgain());
	}
}
