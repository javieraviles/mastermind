package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.AcceptorController;
import urjc.es.mastermind.controllers.ControllerVisitor;
import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.controllers.ResumeController;
import urjc.es.mastermind.controllers.SaveController;
import urjc.es.mastermind.controllers.StartController;

public class View implements ControllerVisitor {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;
	private SaveView saveView;

	public View() {
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
		this.saveView = new SaveView();
	}

	public void interact(AcceptorController acceptorController) {
		acceptorController.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(InGameController inGameController) {
		this.playView.interact(inGameController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

	@Override
	public void visit(SaveController saveController) {
		this.saveView.interact(saveController);
	}

}
