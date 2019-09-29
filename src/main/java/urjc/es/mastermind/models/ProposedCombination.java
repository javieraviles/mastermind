package urjc.es.mastermind.models;

import static urjc.es.mastermind.utils.MessageDialogs.ARROW_TAG;
import static urjc.es.mastermind.utils.MessageDialogs.BLACK_TAG;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_DUPLICATE_COLORS;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_WRONG_COLORS;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_WRONG_LENGTH;
import static urjc.es.mastermind.utils.MessageDialogs.WHITE_TAG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import urjc.es.mastermind.types.CodePeg;

public class ProposedCombination extends Combination {

	private String stringValue;
	private Result result;
	private final Scanner scan = new Scanner(System.in);

	public ProposedCombination() {
		super();
		this.value = new ArrayList<>();
		this.readFromUser();
	}

	public void setResult(final Result result) {
		this.result = result;
	}

	public void write() {
		final String[] message = { stringValue, ARROW_TAG, String.valueOf(result.getBlacks()), BLACK_TAG, "and",
				String.valueOf(result.getWhites()), WHITE_TAG };
		System.out.println(String.join(" ", message));
	}

	public boolean isWinner() {
		return ROW_LENGTH == result.getBlacks();
	}

	public boolean contains(final CodePeg color) {
		return value.contains(color);
	}

	public boolean contains(final CodePeg color, final int position) {
		return color.equals(value.get(position));
	}

	private void readFromUser() {
		String validationError = "";
		do {
			if (!validationError.isEmpty()) {
				System.out.println(validationError);
			}
			stringValue = scan.nextLine();
			validationError = validateProposedCombination();
		} while (!validationError.isEmpty());
	}

	private String validateProposedCombination() {
		if (stringValue.length() != ROW_LENGTH) {
			return MSG_GUESS_WRONG_LENGTH;
		}
		final Set<Character> proposedCombinationSet = stringValue.chars().mapToObj(e -> (char) e)
				.collect(Collectors.toSet());
		if (proposedCombinationSet.size() != ROW_LENGTH) {
			return MSG_GUESS_DUPLICATE_COLORS;
		}
		try {
			for (String possibleCodePeg : stringValue.split("")) {
				CodePeg.valueOf(possibleCodePeg);
			}
		} catch (final IllegalArgumentException e) {
			return MSG_GUESS_WRONG_COLORS + Arrays.asList(CodePeg.values());
		}
		setValueFromStringValue();
		return "";
	}

	private void setValueFromStringValue() {
		for (String codePeg : stringValue.split("")) {
			value.add(CodePeg.valueOf(codePeg));
		}
	}
}
