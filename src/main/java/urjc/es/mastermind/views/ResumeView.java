package urjc.es.mastermind.views;

import urjc.es.mastermind.utils.YesNoDialog;

public class ResumeView {

	public ResumeView() {
	}

	public boolean newGame() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}

}
