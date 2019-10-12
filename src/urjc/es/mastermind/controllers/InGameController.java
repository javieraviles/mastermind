package urjc.es.mastermind.controllers;

import java.util.List;

import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Error;
import urjc.es.mastermind.models.Session;

public class InGameController extends AcceptorController {

	InGameController(Session session) {
		super(session);
		this.proposalController = new ProposalController(session);
		this.undoController = new UndoController(session);
		this.redoController = new RedoController(session);
	}

	private ProposalController proposalController;

	private UndoController undoController;

	private RedoController redoController;

	public void undo() {
		this.undoController.undo();
	}

	public void redo() {
		this.redoController.redo();
	}

	public boolean undoable() {
		return this.undoController.undoable();
	}

	public boolean redoable() {
		return this.redoController.redoable();
	}

	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	public boolean isLooser() {
		return this.proposalController.isLooser();
	}

	public int getAttempts() {
		return this.proposalController.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.proposalController.getColors(position);
	}

	public int getBlacks(int position) {
		return this.proposalController.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.proposalController.getWhites(position);
	}

	public Error addProposedCombination(List<Color> colors) {
		return this.proposalController.addProposedCombination(colors);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
