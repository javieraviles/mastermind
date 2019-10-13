package urjc.es.mastermind.distributed;

import urjc.es.mastermind.distributed.dispatchers.DispatcherPrototype;

public class MastermindServer {
	private DispatcherPrototype dispatcherPrototype;

    private LogicImplementationServer logicServer;

    private MastermindServer() {
        this.dispatcherPrototype = new DispatcherPrototype();
        this.logicServer = new LogicImplementationServer();
        this.logicServer.createDispatchers(this.dispatcherPrototype);
    }

    public static void main(String[] args) {
        new MastermindServer().serve();
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }
}
