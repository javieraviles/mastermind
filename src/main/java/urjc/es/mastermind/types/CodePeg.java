package urjc.es.mastermind.types;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CodePeg {
	r, b, y, g, o, p;

	public static List<CodePeg> getAvailableValues() {
		return Arrays.asList(CodePeg.values()).stream().collect(Collectors.toList());
	}
}
