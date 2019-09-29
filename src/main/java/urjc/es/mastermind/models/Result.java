package urjc.es.mastermind.models;

import java.util.EnumMap;

import urjc.es.mastermind.types.KeyPeg;

public class Result {
	private EnumMap<KeyPeg, Integer> result;

	public Result(final int numberOfBlacks, final int numberOfWhites) {
		result = new EnumMap<>(KeyPeg.class);
		result.put(KeyPeg.b, numberOfBlacks);
		result.put(KeyPeg.w, numberOfWhites);
	}

	public int getBlacks() {
		return result.get(KeyPeg.b);
	}

	public int getWhites() {
		return result.get(KeyPeg.w);
	}

}
