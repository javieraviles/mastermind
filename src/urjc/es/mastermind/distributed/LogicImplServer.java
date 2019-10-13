package urjc.es.mastermind.distributed;

import urjc.es.mastermind.controllers.implementation.LogicImpl;
import urjc.es.mastermind.distributed.dispatchers.DispatcherPrototype;
import urjc.es.mastermind.distributed.dispatchers.ExistsDispatcher;
import urjc.es.mastermind.distributed.dispatchers.FrameType;
import urjc.es.mastermind.distributed.dispatchers.GetAttemptsDispatcher;
import urjc.es.mastermind.distributed.dispatchers.GetBlacksDispatcher;
import urjc.es.mastermind.distributed.dispatchers.GetColorsDispatcher;
import urjc.es.mastermind.distributed.dispatchers.GetTitleDispatcher;
import urjc.es.mastermind.distributed.dispatchers.GetWhitesDispatcher;
import urjc.es.mastermind.distributed.dispatchers.GetWidthDispatcher;
import urjc.es.mastermind.distributed.dispatchers.HasNameDispatcher;
import urjc.es.mastermind.distributed.dispatchers.IsLooserDispatcher;
import urjc.es.mastermind.distributed.dispatchers.IsWinnerDispatcher;
import urjc.es.mastermind.distributed.dispatchers.NextDispatcher;
import urjc.es.mastermind.distributed.dispatchers.ProposeCombinationDispatcher;
import urjc.es.mastermind.distributed.dispatchers.RedoDispatcher;
import urjc.es.mastermind.distributed.dispatchers.RedoableDispatcher;
import urjc.es.mastermind.distributed.dispatchers.ResumeDispatcher;
import urjc.es.mastermind.distributed.dispatchers.SaveDispatcher;
import urjc.es.mastermind.distributed.dispatchers.SaveNamedDispatcher;
import urjc.es.mastermind.distributed.dispatchers.SetTitleDispatcher;
import urjc.es.mastermind.distributed.dispatchers.StartDispatcher;
import urjc.es.mastermind.distributed.dispatchers.StartNameDispatcher;
import urjc.es.mastermind.distributed.dispatchers.StateDispatcher;
import urjc.es.mastermind.distributed.dispatchers.TitlesDispatcher;
import urjc.es.mastermind.distributed.dispatchers.UndoDispatcher;
import urjc.es.mastermind.distributed.dispatchers.UndoableDispatcher;

public class LogicImplServer extends LogicImpl {
	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImpl));
		dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImpl));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.ISLOOSER, new IsLooserDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.ISWINNER, new IsWinnerDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.GETWIDTH, new GetWidthDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.GETWHITES, new GetWhitesDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.GETBLACKS, new GetBlacksDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.GETATTEMPTS, new GetAttemptsDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.GETCOLORS, new GetColorsDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.PROPOSECOMBINATION,
				new ProposeCombinationDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.STARTNAME, new StartNameDispatcher(this.startControllerImpl));
		dispatcherPrototype.add(FrameType.TITLES, new TitlesDispatcher(this.startControllerImpl));
		dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.inGameControllerImpl));
		dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImpl));
		dispatcherPrototype.add(FrameType.SAVENAMED, new SaveNamedDispatcher(this.saveControllerImpl));
		dispatcherPrototype.add(FrameType.HASNAME, new HasNameDispatcher(this.saveControllerImpl));
		dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImpl));
		dispatcherPrototype.add(FrameType.GETTITLE, new GetTitleDispatcher(this.saveControllerImpl));
		dispatcherPrototype.add(FrameType.SETTITLE, new SetTitleDispatcher(this.saveControllerImpl));

	}
}
