package tp1.control.commands;

import java.util.Arrays;
import java.util.List;
import tp1.view.Messages;

public class CommandGenerator {

	private static final List<Command> availableCommands = Arrays.asList( // these are all the possible actions that are going to be parsed by parse method in here
			new ResetCommand(),
			new ActionCommand(),
			new UpdateCommand(),
			new HelpCommand(),
			new ExitCommand(),
			new AddObjectCommand()
	);

	public static Command parse(String[] commandWords) {	

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
		
		commands.append(Messages.HELP);
		
		for (Command c: availableCommands) {
			c.helpText();		// helpText() method for each of the commands
		}
		
		return commands.toString();
	}

}
