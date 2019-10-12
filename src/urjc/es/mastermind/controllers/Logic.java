package urjc.es.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import urjc.es.mastermind.models.Game;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.State;
import urjc.es.mastermind.models.StateValue;

public class Logic {

private Session session;
	
	private Map<StateValue, AcceptorController> controllers;
		
	public Logic() {
		this.session = new Session();
		this.controllers = new HashMap<StateValue, AcceptorController>();
		this.controllers.put(StateValue.INITIAL, new StartController(this.session));
		this.controllers.put(StateValue.IN_GAME, new InGameController(this.session));
		this.controllers.put(StateValue.FINAL, new ResumeController(this.session));
		this.controllers.put(StateValue.EXIT, null);
	}

	public AcceptorController getController() {
		return this.controllers.get(this.session.getValueState());
	}
}
