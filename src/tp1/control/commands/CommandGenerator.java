package tp1.control.commands;

import java.util.Arrays;
import java.util.List;

import tp1.view.Messages;

public class CommandGenerator {

	private static final List<Command> availableCommands = Arrays.asList(
			//TODO fill with your code
			// new UpdateCommand(),
			new HelpCommand(),
			new ExitCommand()
	);

	public static Command parse(String[] commandWords) {	
		if(commandWords[0].equals("")) {				// case in which the user does not enter any text
			return availableCommands.getFirst();		// put as the first command the updateCommand
		}
		for (Command c: availableCommands) {
			Command command = c.parse(commandWords);
			if(command != null) {
				return command;
			}
		}
		return null;
	}
		
	public static String commandHelp() {
		StringBuilder commands = new StringBuilder();
		
		commands.append(Messages.HELP_AVAILABLE_COMMANDS).append(Messages.LINE_SEPARATOR);
		
		for (Command c: availableCommands) {
			c.helpText();		// helpText() method for each of the commands
		}
		
		return commands.toString();
	}

}
