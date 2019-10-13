package urjc.es.mastermind.controllers;

import java.util.List;

import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Error;
import urjc.es.mastermind.models.Session;

public abstract class InGameController extends AcceptorController {

	protected InGameController(Session session) {
		super(session);
	}

	public abstract void undo();

	public abstract void redo();

	public abstract boolean undoable();

	public abstract boolean redoable();

	public abstract boolean isWinner();

	public abstract boolean isLooser();

	public abstract int getAttempts();

	public abstract List<Color> getColors(int position);

	public abstract int getBlacks(int position);

	public abstract int getWhites(int position);

	public abstract Error addProposedCombination(List<Color> colors);

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
