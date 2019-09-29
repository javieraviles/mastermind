package urjc.es.mastermind.models;

import static urjc.es.mastermind.utils.MessageDialogs.ATTEMPT_TAG;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_LOSE;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_WIN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeBreaker {

	private final Scanner scan = new Scanner(System.in);
	private final char continueChar = 's';
	private int maxAttempts;
	private List<ProposedCombination> proposedCombinations;

	public CodeBreaker(final int maxAttempts) {
		super();
		this.maxAttempts = maxAttempts;
		prepareForNewGame();
	}

	public ProposedCombination getLastProposedCombination() {
		return proposedCombinations.get(proposedCombinations.size() - 1);
	}

	public boolean askToPlayAgain() {
		return scan.nextLine().charAt(0) == continueChar;
	}

	public void proposeCombination() {
		proposedCombinations.add(new ProposedCombination());
	}

	public void writeProposedCombinations() {
		for (ProposedCombination proposedCombination : proposedCombinations) {
			proposedCombination.write();
		}
	}

	public void prepareForNewGame() {
		this.proposedCombinations = new ArrayList<>();
	}

	public void writeAttempts() {
		final String[] attemptsMessage = { String.valueOf(proposedCombinations.size()), ATTEMPT_TAG };
		System.out.println(String.join(" ", attemptsMessage));
	}

	public boolean didAlreadyWonOrLost() {
		if (getLastProposedCombination().isWinner()) {
			System.out.println(MSG_WIN);
			return true;
		} else if (maxAttempts == proposedCombinations.size()) {
			System.out.println(MSG_LOSE);
		}
		return false;
	}

}
