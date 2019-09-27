package urjc.es.mastermind.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import urjc.es.mastermind.types.CodePeg;
import urjc.es.mastermind.types.GuessFeedback;

public class CodeMaker {

	private int rowLength;
	private List<CodePeg> pattern;
	final Random random = new Random();

	public CodeMaker(final int rowLength) {
		super();
		this.rowLength = rowLength;
	}

	public List<CodePeg> getPattern() {
		return Collections.unmodifiableList(pattern);
	}

	public GuessFeedback compareGuessWithPattern(final List<CodePeg> guessList) {

		int sameColorAndPosition = 0;
		int sameColor = 0;

		for (int i = 0; i < rowLength; i++) {
			if (pattern.get(i).equals(guessList.get(i))) {
				sameColorAndPosition++;
			}
			if (pattern.contains(guessList.get(i))) {
				sameColor++;
			}
		}

		// sameColor contains the ones with right position too
		final int numberOfWhites = sameColor - sameColorAndPosition;

		return new GuessFeedback(sameColorAndPosition, numberOfWhites);
	}

	public void generatePattern() {
		pattern.clear();
		// clone values, otherwise could modify original
		final List<CodePeg> codePegValues = Arrays.asList(CodePeg.values()).stream().collect(Collectors.toList());
		for (int i = 0; i < rowLength; i++) {
			int randomNumber = random.nextInt(codePegValues.size());
			final CodePeg randomColorPeg = codePegValues.get(randomNumber);
			pattern.add(randomColorPeg);
			// remove picked color so cannot be duplicated
			codePegValues.remove(randomColorPeg);
		}
	}

}
