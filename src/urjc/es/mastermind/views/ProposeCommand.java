package urjc.es.mastermind.views;

import java.util.List;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Error;

public class ProposeCommand extends Command {
	ProposeCommand(InGameController inGameController) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), inGameController);
	}

	@Override
	protected void execute() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(this.inGameController).read();
			error = this.inGameController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		new GameView(this.inGameController);
	}

	@Override
	protected boolean isActive() {
		return true;
	}
}
