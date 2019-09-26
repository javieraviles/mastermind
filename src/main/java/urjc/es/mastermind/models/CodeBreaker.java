package urjc.es.mastermind.models;

import java.util.Scanner;

public class CodeBreaker {

	private final Scanner scan = new Scanner(System.in);
	private final char continueChar = 's';

	public CodeBreaker() {
		super();
	}

	public String introduceGuess() {
		return scan.nextLine();
	}

	public boolean askToPlayAgain() {
		return scan.nextLine().charAt(0) == continueChar;
	}

}
