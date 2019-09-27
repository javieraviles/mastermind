package urjc.es.mastermind.models;

import java.util.Scanner;

import urjc.es.mastermind.types.Guess;

public class CodeBreaker {

	private final Scanner scan = new Scanner(System.in);
	private final char continueChar = 's';
	private int rowLength;

	public CodeBreaker(final int rowLength) {
		super();
		this.rowLength = rowLength;
	}

	public boolean askToPlayAgain() {
		return scan.nextLine().charAt(0) == continueChar;
	}

	// the code breaker should insert guesses until it complies with the rules
	public Guess generateValidGuess() {
		Guess guess = null;
		do {
			if (guess != null && !guess.getErrorInGuess().isEmpty()) {
				System.out.println(guess.getErrorInGuess());
			}
			guess = new Guess(introduceGuess(), rowLength);
		} while (!guess.getErrorInGuess().isEmpty());
		return guess;
	}

	private String introduceGuess() {
		return scan.nextLine();
	}

}
