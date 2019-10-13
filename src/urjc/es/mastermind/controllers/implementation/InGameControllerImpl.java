package urjc.es.mastermind.controllers.implementation;

import java.util.List;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.controllers.ProposalController;
import urjc.es.mastermind.controllers.RedoController;
import urjc.es.mastermind.controllers.UndoController;
import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Error;
import urjc.es.mastermind.models.Session;

public class InGameControllerImpl extends InGameController {

	public InGameControllerImpl(Session session) {
		super(session);
		this.proposalController = new ProposalController(session);
		this.undoController = new UndoController(session);
		this.redoController = new RedoController(session);
	}

	private ProposalController proposalController;
	private UndoController undoController;
	private RedoController redoController;
	
	@Override
	public void undo() {
		this.undoController.undo();
	}

	@Override
	public void redo() {
		this.redoController.redo();
	}

	@Override
	public boolean undoable() {
		return this.undoController.undoable();
	}

	@Override
	public boolean redoable() {
		return this.redoController.redoable();
	}

	@Override
	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	@Override
	public boolean isLooser() {
		return this.proposalController.isLooser();
	}

	@Override
	public int getAttempts() {
		return this.proposalController.getAttempts();
	}

	@Override
	public List<Color> getColors(int position) {
		return this.proposalController.getColors(position);
	}

	@Override
	public int getBlacks(int position) {
		return this.proposalController.getBlacks(position);
	}

	@Override
	public int getWhites(int position) {
		return this.proposalController.getWhites(position);
	}

	@Override
	public Error addProposedCombination(List<Color> colors) {
		return this.proposalController.addProposedCombination(colors);
	}

}
