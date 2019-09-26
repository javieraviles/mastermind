package urjc.es.mastermind.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import urjc.es.mastermind.types.CodePeg;
import urjc.es.mastermind.types.KeyPeg;

public class CodeMaker {

	private int rowLength;
	private List<CodePeg> pattern;

	public CodeMaker(final int rowLength) {
		super();
		this.rowLength = rowLength;
	}

	public List<CodePeg> getPattern() {
		return Collections.unmodifiableList(pattern);
	}

	public Map<KeyPeg, Integer> compareGuessWithPattern(final List<CodePeg> guessAsList) {

		final Map<KeyPeg, Integer> guessFeedback = new HashMap<>();
		int sameColorAndPosition = 0;
		int sameColor = 0;

		for (int i = 0; i < rowLength; i++) {
			if (pattern.get(i).equals(guessAsList.get(i))) {
				sameColorAndPosition++;
			}
			if (pattern.contains(guessAsList.get(i))) {
				sameColor++;
			}
		}

		guessFeedback.put(KeyPeg.b, sameColorAndPosition);
		// sameColor contains the ones with right position too
		guessFeedback.put(KeyPeg.w, sameColor - sameColorAndPosition);

		return guessFeedback;
	}

	public void generatePattern() {
		pattern.clear();
		// clone values, otherwise could modify original
		final List<CodePeg> codePegValues = Arrays.asList(CodePeg.values()).stream().collect(Collectors.toList());
		final Random random = new Random();
		for (int i = 0; i < rowLength; i++) {
			int randomNumber = random.nextInt(codePegValues.size());
			final CodePeg randomColorPeg = codePegValues.get(randomNumber);
			pattern.add(randomColorPeg);
			// remove picked color so cannot be duplicated
			codePegValues.remove(randomColorPeg);
		}
	}

}
