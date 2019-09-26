package urjc.es.mastermind.models;

import java.util.List;

public class DecodingBoard {

	private List<String> rows;

	public DecodingBoard() {
		super();
	}

	public void fillRow(final String row) {
		rows.add(row);
	}

	public void printDecodingBoard() {
		for (String row : rows) {
			System.out.println(row);
		}
	}

	public void clear() {
		rows.clear();
	}

}
