package urjc.es.mastermind.controllers.implementation;

import urjc.es.mastermind.controllers.ResumeController;
import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.models.SessionImpl;

public class ResumeControllerImpl extends ResumeController {

	public ResumeControllerImpl(Session session) {
		super(session);
	}

	@Override
	public void resume(boolean newGame) {
		if (newGame) {
			((SessionImpl) this.session).clearGame();
		} else {
			((SessionImpl) this.session).next();
		}
	}
}
