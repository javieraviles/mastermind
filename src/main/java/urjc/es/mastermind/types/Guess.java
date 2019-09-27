package urjc.es.mastermind.types;

import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_DUPLICATE_COLORS;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_WRONG_COLORS;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_WRONG_LENGTH;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Guess {
	
	private String stringValue;
	private List<CodePeg> value;
	private String errorInGuess;
	private int rowLength;

	public Guess(final String stringValue, final int rowLength) {
		this.stringValue = stringValue;
		this.rowLength = rowLength;
		validate();
	}

	public String getStringValue() {
		return stringValue;
	}

	public List<CodePeg> getValue() {
		return value;
	}

	public String getErrorInGuess() {
		return errorInGuess;
	}

	// fill the error detected in a string guess, create a typed guess if none.
	private void validate() {

		if (stringValue.length() != rowLength) {
			errorInGuess = MSG_GUESS_WRONG_LENGTH;
		}

		// cast guess to a Set of Characters, then check length again
		final Set<Character> guessSet = stringValue.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
		if (guessSet.size() != rowLength) {
			errorInGuess = MSG_GUESS_DUPLICATE_COLORS;
		}

		// every Char in a guess should be a valid CodePeg
		try {
			for (String possibleCodePeg : stringValue.split("")) {
				CodePeg.valueOf(possibleCodePeg);
			}
		} catch (final IllegalArgumentException e) {
			errorInGuess = MSG_GUESS_WRONG_COLORS + Arrays.asList(CodePeg.values());
		}

		convertGuessToCodePegList();
	}

	private List<CodePeg> convertGuessToCodePegList() {
		for (String codePeg : stringValue.split("")) {
			value.add(CodePeg.valueOf(codePeg));
		}
		return value;
	}
}
