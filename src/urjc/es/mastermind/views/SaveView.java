package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.SaveController;
import urjc.es.mastermind.utils.WithConsoleView;
import urjc.es.mastermind.utils.YesNoDialog;

class SaveView extends WithConsoleView {

	void interact(SaveController saveController) {
		boolean save = new YesNoDialog().read(MessageView.SAVE.getMessage());
		String name = null;
		if (save) {
			if (saveController.hasName()) {
				saveController.save();
			} else {
				boolean exists = false;
				do {
					name = this.console.readString(MessageView.NAME.getMessage());
					exists = saveController.exists(name);
					if (exists) {
						this.console.writeln(MessageView.PROPOSAL_EXISTS.getMessage());
					}
				} while (exists);
				saveController.save(name);
			}
		}
		saveController.next();
	}

}