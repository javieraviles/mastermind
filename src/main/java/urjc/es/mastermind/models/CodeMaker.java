package urjc.es.mastermind.models;

public class CodeMaker {

	private CodeBreaker codeBreaker;
	private SecretCombination secretCombination;

	public CodeMaker(final CodeBreaker codeBreaker) {
		super();
		this.codeBreaker = codeBreaker;
		prepareForNewGame();
	}

	public void answerProposal() {
		secretCombination.calculateResult(codeBreaker.getLastProposedCombination());
	}

	public void prepareForNewGame() {
		this.secretCombination = new SecretCombination();
	}

	public void writeSecretCombination() {
		secretCombination.write();
	}

}
