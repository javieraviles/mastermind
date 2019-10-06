package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Game;
import urjc.es.mastermind.models.State;

public class StartController extends Controller {

	public StartController(Game game, State state) {
		super(game, state);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

	public void start() {
		this.state.next();
	}

}
