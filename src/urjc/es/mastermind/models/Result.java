package urjc.es.mastermind.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import urjc.es.mastermind.utils.WithConsoleView;

public class Result extends WithConsoleView {

	private int blacks = 0;
	private int whites = 0;

	public Result() {
	}

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	int getBlacks() {
		return this.blacks;
	}

	int getWhites() {
		return this.whites;
	}

	boolean isWinner() {
		return Combination.getWidth() == this.blacks;
	}

	Result copy() {
		return new Result(this.blacks, this.whites);
	}

	void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.blacks + "\n");
			fileWriter.write(this.whites + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load(BufferedReader bufferedReader) {
		try {
			this.blacks = Integer.parseInt(bufferedReader.readLine());
			this.whites = Integer.parseInt(bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
