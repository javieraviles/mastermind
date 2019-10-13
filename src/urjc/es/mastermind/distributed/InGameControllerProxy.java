package urjc.es.mastermind.distributed;

import java.util.ArrayList;
import java.util.List;

import urjc.es.mastermind.controllers.InGameController;
import urjc.es.mastermind.distributed.dispatchers.FrameType;
import urjc.es.mastermind.distributed.dispatchers.TCPIP;
import urjc.es.mastermind.models.Color;
import urjc.es.mastermind.models.Error;
import urjc.es.mastermind.models.Session;

public class InGameControllerProxy extends InGameController {

	private TCPIP tcpip;

	public InGameControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void undo() {
		this.tcpip.send(FrameType.UNDO.name());
	}

	@Override
	public void redo() {
		this.tcpip.send(FrameType.REDO.name());
	}

	@Override
	public boolean undoable() {
		this.tcpip.send(FrameType.UNDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean redoable() {
		this.tcpip.send(FrameType.REDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean isWinner() {
		this.tcpip.send(FrameType.ISWINNER.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean isLooser() {
		this.tcpip.send(FrameType.ISLOOSER.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public int getAttempts() {
		this.tcpip.send(FrameType.GETATTEMPTS.name());
		return this.tcpip.receiveInt();
	}

	@Override
	public List<Color> getColors(int position) {
		this.tcpip.send(FrameType.GETCOLORS.name());
		this.tcpip.send(position);
		int size = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>();
		for (int i = 0; i < size; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		return colors;
	}

	@Override
	public int getBlacks(int position) {
		this.tcpip.send(FrameType.GETBLACKS.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

	@Override
	public int getWhites(int position) {
		this.tcpip.send(FrameType.GETWHITES.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

	@Override
	public Error addProposedCombination(List<Color> colors) {
		this.tcpip.send(FrameType.PROPOSECOMBINATION.name());
		this.tcpip.send(colors.size());
		for (Color color : colors) {
			this.tcpip.send(color);
		}
		Error error = this.tcpip.receiveError();
		return error;
	}

}
