package tp1.exceptions;

import tp1.view.Messages;

public class CommandParseException extends CommandException {

	public final String text = PARSE_EXCEPTION_MESSAGE;
	
	public CommandParseException(String text) {
		super(text);
	}

	private static final long serialVersionUID = 1L;
	

}
