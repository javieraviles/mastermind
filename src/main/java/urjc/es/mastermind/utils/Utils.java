package urjc.es.mastermind.utils;

import static urjc.es.mastermind.utils.MessageDialogs.ARROW_TAG;
import static urjc.es.mastermind.utils.MessageDialogs.BLACK_TAG;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_DUPLICATE_COLORS;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_WRONG_COLORS;
import static urjc.es.mastermind.utils.MessageDialogs.MSG_GUESS_WRONG_LENGTH;
import static urjc.es.mastermind.utils.MessageDialogs.WHITE_TAG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import urjc.es.mastermind.types.CodePeg;
import urjc.es.mastermind.types.KeyPeg;

public class Utils {

	public static String formatFeedback(final String guess, final Map<KeyPeg, Integer> guessFeedback) {
		return guess + ARROW_TAG + guessFeedback.get(KeyPeg.b) + BLACK_TAG + " and " + guessFeedback.get(KeyPeg.w)
				+ WHITE_TAG;
	}

	public static List<CodePeg> convertGuessToCodePegList(final String guess) {
		final List<CodePeg> guessAsList = new ArrayList<>();
		for (String codePeg : guess.split("")) {
			guessAsList.add(CodePeg.valueOf(codePeg));
		}
		return guessAsList;
	}

	// return the error detected in a guess, empty if none.
	public static String validateGuess(final String guess, final int rowLength) {

		if (guess.length() != rowLength) {
			return MSG_GUESS_WRONG_LENGTH;
		}

		// cast guess to a Set of Characters, then check length again
		final Set<Character> guessAsSet = guess.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
		if (guessAsSet.size() != rowLength) {
			return MSG_GUESS_DUPLICATE_COLORS;
		}

		// every Char in a guess should be a valid CodePeg
		try {
			for (String possibleCodePeg : guess.split("")) {
				CodePeg.valueOf(possibleCodePeg);
			}
		} catch (final IllegalArgumentException e) {
			return MSG_GUESS_WRONG_COLORS + Arrays.asList(CodePeg.values());
		}
		return "";
	}

}
