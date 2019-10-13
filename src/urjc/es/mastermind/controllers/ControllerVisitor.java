package urjc.es.mastermind.controllers;

public interface ControllerVisitor {

	void visit(StartController startController);

	void visit(InGameController InGameController);

	void visit(ResumeController resumeController);

	void visit(SaveController saveController);
}
