package tp1.exceptions;

public class CommandException extends Exception {

	private static final long serialVersionUID = 1L;
	private String text;
	
	public CommandException(String text) {
		this.text = text;
	}
	
}
