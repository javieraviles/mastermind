package urjc.es.mastermind.models;

import java.util.Collections;
import java.util.List;

import urjc.es.mastermind.types.CodePeg;

public abstract class Combination {

	protected static final int ROW_LENGTH = 4;
	protected List<CodePeg> value;

	public List<CodePeg> getValue() {
		return Collections.unmodifiableList(value);
	}

	public int getRowLength() {
		return ROW_LENGTH;
	}
}
