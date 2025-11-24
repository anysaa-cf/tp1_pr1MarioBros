package tp1.exceptions;

public class CommandParseException extends CommandException {
	
	private static final long serialVersionUID = 1L;
	
	public CommandParseException(String text) {
		super(text);
	}
}
