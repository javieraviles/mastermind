package urjc.es.mastermind.types;

import static urjc.es.mastermind.utils.MessageDialogs.ARROW_TAG;
import static urjc.es.mastermind.utils.MessageDialogs.BLACK_TAG;
import static urjc.es.mastermind.utils.MessageDialogs.WHITE_TAG;

import java.util.EnumMap;

public class GuessFeedback {
	private EnumMap<KeyPeg, Integer> feedback;

	public GuessFeedback(final int numberOfBlacks, final int numberOfWhites) {
		feedback = new EnumMap<>(KeyPeg.class);
		feedback.put(KeyPeg.b, numberOfBlacks);
		feedback.put(KeyPeg.w, numberOfWhites);
	}

	public int getBlacks() {
		return feedback.get(KeyPeg.b);
	}

	public int getWhites() {
		return feedback.get(KeyPeg.w);
	}

	public String formatMessage(final String guess) {
		final String[] message = { guess, ARROW_TAG, String.valueOf(getBlacks()), BLACK_TAG, "and",
				String.valueOf(getWhites()), WHITE_TAG };

		return String.join(" ", message);
	}
}
