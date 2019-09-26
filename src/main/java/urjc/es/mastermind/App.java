package urjc.es.mastermind;

public class App {
	public static void main(String[] args) {
		final int maxAttempts = 10;
		final int rowLength = 4;

		Game mastermind = new Game(maxAttempts, rowLength);
		mastermind.start();
	}
}
