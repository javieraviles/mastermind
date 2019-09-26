package urjc.es.mastermind;

import java.util.Scanner;

public class CodeBreaker {
	
	private final Scanner scan = new Scanner(System.in);
	private final char continueChar = 's';
	
	public CodeBreaker() {
	}
	
	public String introduceGuess() {
		return scan.nextLine();
	}
	
	public boolean askToPlayAgain() {
		return scan.nextLine().charAt(0) == continueChar;
	}

}
