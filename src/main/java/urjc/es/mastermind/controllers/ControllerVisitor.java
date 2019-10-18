package urjc.es.mastermind.controllers;

public interface ControllerVisitor {

    void visit(StartController startController);

    void visit(ProposalController proposalController);

    void visit(ResumeController resumeController);
}
