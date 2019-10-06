package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.ResumeController;
import urjc.es.mastermind.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}
	
}
