package urjc.es.mastermind.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import urjc.es.mastermind.types.CodePeg;

public class SecretCombination extends Combination {

	public SecretCombination() {
		super();
		generateSecretCombination();
	}

	public void calculateResult(final ProposedCombination proposedCombination) {
		int sameColorAndPosition = 0;
		int sameColor = 0;
		for (int i = 0; i < ROW_LENGTH; i++) {
			if (proposedCombination.contains(value.get(i), i)) {
				sameColorAndPosition++;
			}
			if (proposedCombination.contains(value.get(i))) {
				sameColor++;
			}
		}
		final int numberOfWhites = sameColor - sameColorAndPosition;
		proposedCombination.setResult(new Result(sameColorAndPosition, numberOfWhites));
	}

	public void write() {
		StringBuilder sb = new StringBuilder(value.size());
		for (int i = 0; i < value.size(); i++) {
			sb.append('*');
		}
		System.out.println(sb.toString());
	}

	private void generateSecretCombination() {
		value = new ArrayList<>();
		final Random random = new Random();
		final List<CodePeg> codePegValues = CodePeg.getAvailableValues();
		for (int i = 0; i < ROW_LENGTH; i++) {
			int randomNumber = random.nextInt(codePegValues.size());
			final CodePeg randomColorPeg = codePegValues.get(randomNumber);
			value.add(randomColorPeg);
			codePegValues.remove(randomColorPeg);
		}
	}

}
