package urjc.es.mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import urjc.es.mastermind.models.SessionImpl;
import urjc.es.mastermind.models.StateValue;

public class SessionImplDAO {

	public static final String EXTENSION = ".klond";

	public static final String DIRECTORY = System.getProperty("user.dir") + "/partidas";

	private static File directory;

	static {
		SessionImplDAO.directory = new File(SessionImplDAO.DIRECTORY);
		if (!SessionImplDAO.directory.exists()) {
			SessionImplDAO.directory.mkdir();
		}
	}

	private final SessionImpl sessionImpl;

	private final GameDAO gameDAO;

	public SessionImplDAO(SessionImpl sessionImpl) {
		this.sessionImpl = sessionImpl;
		this.gameDAO = new GameDAO(sessionImpl.getGame());
	}

	public void save() {
		this.save(this.sessionImpl.getName());
	}

	public void save(String name) {
		if (!name.endsWith(SessionImplDAO.EXTENSION)) {
			name = name + SessionImplDAO.EXTENSION;
		}
		File file = new File(SessionImplDAO.directory, name);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.gameDAO.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(String name) {
		this.sessionImpl.setName(name);
		File file = new File(SessionImplDAO.directory, name);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.gameDAO.load(bufferedReader);
			this.sessionImpl.resetRegistry();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.sessionImpl.setStateValue(StateValue.IN_GAME);
		if (this.sessionImpl.isLooser() || this.sessionImpl.isWinner()) {
			this.sessionImpl.setStateValue(StateValue.FINAL);
		}
	}

	public String[] getGamesNames() {
		return SessionImplDAO.directory.list();
	}

	public boolean exists(String name) {
		for (String auxName : this.getGamesNames()) {
			if (auxName.equals(name + SessionImplDAO.EXTENSION)) {
				return true;
			}
		}
		return false;
	}
}
