package urjc.es.mastermind.models;

import java.util.List;

import urjc.es.mastermind.utils.WithConsoleView;

import java.util.ArrayList;

public abstract class Combination extends WithConsoleView {
	
	private static final int ROW_LENGTH = 4;

	public List<Color> colors;
	
	protected Combination (){
		this.colors = new ArrayList<Color>();
	}
	
	public static int getWidth() {
		return Combination.ROW_LENGTH;
	}
	
}
