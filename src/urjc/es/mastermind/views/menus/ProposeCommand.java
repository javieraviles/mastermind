package urjc.es.mastermind.views.menus;

import java.util.List;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Error;
import urjc.es.mastermind.views.ErrorView;
import urjc.es.mastermind.views.GameView;
import urjc.es.mastermind.views.MessageView;
import urjc.es.mastermind.views.ProposedCombinationView;

public class ProposeCommand extends Command {
	public ProposeCommand(InGameController inGameController) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), inGameController);
	}

	@Override
	protected void execute() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView((InGameController) this.acceptorController).read();
			error = ((InGameController) this.acceptorController).addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		new GameView(((InGameController) this.acceptorController));
	}

	@Override
	protected boolean isActive() {
		return true;
	}
}
