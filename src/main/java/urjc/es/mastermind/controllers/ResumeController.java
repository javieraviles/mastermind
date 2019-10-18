package urjc.es.mastermind.controllers;

import urjc.es.mastermind.models.Session;
import urjc.es.mastermind.views.ResumeView;

public class ResumeController extends Controller {

	public ResumeController(Session session) {
		super(session);
	}

	public void control() {
		if (new ResumeView().newGame()) {
			this.session.resume();
		}
		this.session.next();
	}

}
