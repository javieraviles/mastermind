package urjc.es.mastermind.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import urjc.es.mastermind.utils.WithConsoleView;

public abstract class Combination extends WithConsoleView {

	private static final int ROW_LENGTH = 4;

	public List<Color> colors;

	protected Combination() {
		this.colors = new ArrayList<Color>();
	}

	public static int getWidth() {
		return Combination.ROW_LENGTH;
	}

	void save(FileWriter fileWriter) {
		try {
			for (Color color : this.colors) {
				fileWriter.write(color.name() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load(BufferedReader bufferedReader) {
		try {
			for (int i = 0; i < Combination.getWidth(); i++) {
				String color = bufferedReader.readLine();
				this.colors.add(Color.valueOf(color));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
