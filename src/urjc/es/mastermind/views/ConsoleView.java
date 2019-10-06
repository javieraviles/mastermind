package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.Controller;
import urjc.es.mastermind.controllers.ProposalController;
import urjc.es.mastermind.controllers.ResumeController;
import urjc.es.mastermind.controllers.StartController;

public class ConsoleView extends View {
	
	private StartView startView;
	
	private ProposalView proposalView;
	
	private ResumeView resumeView;
	
	public ConsoleView(){
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}
	
	@Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}

	public void visit(ProposalController proposalController) {
		this.proposalView.interact(proposalController);
	}

	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

}
