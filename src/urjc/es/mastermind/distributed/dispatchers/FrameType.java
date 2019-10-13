package urjc.es.mastermind.distributed.dispatchers;

public enum FrameType {
	START, NEW_GAME, STATE, ISLOOSER, ISWINNER, GETWIDTH, GETATTEMPTS, GETCOLORS, GETWHITES, GETBLACKS, CLOSE, UNDO,
	REDO, UNDOABLE, REDOABLE, PROPOSECOMBINATION, GETTITLE, SETTITLE, STARTNAME, TITLES, SAVE, SAVENAMED, NEXT, HASNAME,
	EXISTS;

	public static FrameType parser(String string) {
		for (FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
