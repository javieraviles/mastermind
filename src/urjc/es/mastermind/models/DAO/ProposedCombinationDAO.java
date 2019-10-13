package urjc.es.mastermind.models.DAO;

import urjc.es.mastermind.models.ProposedCombination;

class ProposedCombinationDAO extends CombinationDAO {

	ProposedCombinationDAO(ProposedCombination proposedCombination) {
		super(proposedCombination);
	}

	ProposedCombination getProposedCombination() {
		return (ProposedCombination) this.combination;
	}

}