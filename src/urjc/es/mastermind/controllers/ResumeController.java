package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Game;
import urjc.es.mastermind.models.State;

public class ResumeController extends Controller {

	public ResumeController(Game game, State state) {
		super(game, state);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}
	
	public void resume(boolean playAgain) {
		if (playAgain) {
			this.state.reset();
			this.game.clear();
		} else {
			this.state.next();
		}
	}

}
