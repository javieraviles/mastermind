package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Game;
import urjc.es.mastermind.models.State;

public abstract class Controller {

	protected Game game;
	protected State state;

	Controller(Game game, State state) {
		this.game = game;
		this.state = state;
	}

	public abstract void accept(ControllerVisitor controllerVisitor);
	
	public int getRowLength() {
		return this.game.getRowLength();
	}


}
