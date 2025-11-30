package tp1.control.commands;

import tp1.exceptions.CommandParseException;
import tp1.view.Messages;

public abstract class NoParamsCommand extends AbstractCommand {

	public NoParamsCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
	    // in fact, commandWords.length == 0 not possible due to strip() in getPrompt() method
	    if (commandWords.length != 0 && matchCommandName(commandWords[0]))
	      if (commandWords.length > 1)      // there are extraneous parameters
	        throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
	      else
	        return this;
	    return null;
	}
}

/*
 * Not matching the command name is not an error but simply an indication 
 * that the input text does not correspond to this particular command so, 
 * in this case, the parse method must not throw an exception and must 
 * return null as it did in the previous assignment, to enable the parse 
 * methods of the other commands to also check for a match.
 */