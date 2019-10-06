package urjc.es.mastermind.views;

import urjc.es.mastermind.controllers.Controller;
import urjc.es.mastermind.controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor {

	public abstract void interact(Controller controller);

}
