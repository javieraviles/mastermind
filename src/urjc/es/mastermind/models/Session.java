package urjc.es.mastermind.models;

public interface Session {

	public abstract int getWidth();

	public abstract StateValue getValueState();

	String getName();

	void setName(String title);

}
