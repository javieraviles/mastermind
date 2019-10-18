package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.views.SecretCombinationView;
import urjc.es.mastermind.views.StartView;

public class StartController extends Controller {

	public StartController(Session session) {
		super(session);
	}

	public void control() {
		new StartView().writeGameIntro();
		new SecretCombinationView().writeln(this.session.getGameRowLength());
		session.next();
	}

}
