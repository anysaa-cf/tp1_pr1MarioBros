package tp1.control.commands;

import tp1.exceptions.CommandParseException;
import tp1.view.Messages;

public abstract class NoParamsCommand extends AbstractCommand {

	public NoParamsCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	  public Command parse(String[] commandWords) throws CommandParseException {
	    // in fact, commandWords.length == 0 not possible due to strip() in getPrompt() method

	    if (commandWords.length != 0 && matchCommandName(commandWords[0]))
	      if (commandWords.length == 1)  // there are unnecessary parameters
	        return this;
	    throw new CommandParseException(Messages.INVALID_COMMAND);
	  }
}