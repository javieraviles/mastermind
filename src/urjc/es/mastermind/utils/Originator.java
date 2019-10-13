package urjc.es.mastermind.utils;

import urjc.es.mastermind.models.Memento;

public interface Originator {

	void restore(Memento memento);

	Memento createMemento();

}