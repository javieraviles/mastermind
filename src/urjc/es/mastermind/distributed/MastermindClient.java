package urjc.es.mastermind.distributed;

import urjc.es.mastermind.Mastermind;
import urjc.es.mastermind.controllers.Logic;

public class MastermindClient extends Mastermind {
	private LogicProxy logicProxy;

	public static void main(String[] args) {
		new MastermindClient().play();
	}

	@Override
	protected Logic createLogic() {
		this.logicProxy = new LogicProxy();
		return this.logicProxy;
	}

	@Override
	protected void play() {
		super.play();
		this.logicProxy.close();
	}
}
