package urjc.es.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import urjc.es.mastermind.utils.WithConsoleView;

public abstract class Combination extends WithConsoleView {

	private static final int ROW_LENGTH = 4;

	protected List<Color> colors;

	protected Combination() {
		this.colors = new ArrayList<Color>();
	}

	public void clearColors() {
		this.colors.clear();
	}

	public void addColor(Color color) {
		this.colors.add(color);
	}

	public static int getWidth() {
		return Combination.ROW_LENGTH;
	}

	public List<Color> getColors() {
		return this.colors;
	}
}
