package urjc.es.mastermind.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SessionImpl implements Session {

	public static final String EXTENSION = ".mastermind";

	public static final String DIRECTORY = System.getProperty("user.dir") + "/games";

	private static File directory;

	static {
		SessionImpl.directory = new File(SessionImpl.DIRECTORY);
		if (!SessionImpl.directory.exists()) {
			SessionImpl.directory.mkdir();
		}
	}

	private State state;
	private Game game;
	private Registry registry;
	private String name;

	public SessionImpl() {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(this.game);
	}

	public void load(String name) {
		this.name = name;
		File file = new File(SessionImpl.directory, name);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.game.load(bufferedReader);
			this.registry.reset();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.state.setStateValue(StateValue.IN_GAME);
		if (this.isLooser() || this.isWinner()) {
			this.state.setStateValue(StateValue.FINAL);
		}
	}

	public void save() {
		this.save(this.name);
	}

	public void save(String name) {
		if (!name.endsWith(SessionImpl.EXTENSION)) {
			name = name + SessionImpl.EXTENSION;
		}
		File file = new File(SessionImpl.directory, name);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.game.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getGamesNames() {
		return SessionImpl.directory.list();
	}

	public boolean exists(String name) {
		for (String auxName : this.getGamesNames()) {
			if (auxName.equals(name + SessionImpl.EXTENSION)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasName() {
		return this.name != null;
	}

	public void next() {
		this.state.next();
	}

	public void addProposedCombination(List<Color> colors) {
		this.game.addProposedCombination(colors);
		this.registry.registry();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}

	public void clearGame() {
		this.game.clear();
		this.state.reset();
		this.registry.reset();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}

	public int getWidth() {
		return this.game.getWidth();
	}

	public int getAttempts() {
		return this.game.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.game.getColors(position);
	}

	public int getBlacks(int position) {
		return this.game.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.game.getWhites(position);
	}

	public StateValue getValueState() {
		return this.state.getValueState();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
