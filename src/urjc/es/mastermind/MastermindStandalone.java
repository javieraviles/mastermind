package urjc.es.mastermind;

import urjc.es.mastermind.controllers.Logic;
import urjc.es.mastermind.controllers.implementation.LogicImpl;

public class MastermindStandalone extends Mastermind {
	public static void main(String[] args) {
		new MastermindStandalone().play();
	}

	@Override
	protected Logic createLogic() {
		return new LogicImpl();
	}
}
