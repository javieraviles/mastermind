package urjc.es.mastermind.views;

import urjc.es.mastermind.models.Error;
import urjc.es.mastermind.utils.Console;

public class ErrorView {

	public static final String[] MESSAGES = { "Repeated colors",
			"Wrong colors, they must be: " + ColorView.allInitials(), "Wrong proposed combination length" };

	protected Error error;

	public ErrorView(Error error) {
		this.error = error;
	}

	public String getMessage() {
		return ErrorView.MESSAGES[this.error.ordinal()];
	}

	public void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}
}
