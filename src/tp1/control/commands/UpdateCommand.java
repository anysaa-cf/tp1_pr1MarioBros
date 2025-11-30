package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class UpdateCommand extends NoParamsCommand{

	private static final String NAME = Messages.COMMAND_UPDATE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_UPDATE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_UPDATE_DETAILS;
	private static final String HELP = Messages.COMMAND_UPDATE_HELP;

	public UpdateCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP); 
	}

	@Override
	public void execute(GameModel game, GameView view) throws CommandExecuteException{
		try {
			game.update();
			view.showGame();			
		} catch(GameModelException gme) {
			throw new CommandExecuteException(Messages.ERROR_COMMAND_EXECUTE, gme);
		}
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length > 1) {
				throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
			}
			
			else if (commandWords.length == 0 || (commandWords.length == 1 && commandWords[0].isEmpty())) {
				return this;
			}
		}
		return null;
	}

	public String helpText() {
		return DETAILS + ": " + HELP;
	}

	
}
