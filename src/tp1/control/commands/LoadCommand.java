package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class LoadCommand extends AbstractCommand {
	
	private static final String NAME = Messages.COMMAND_LOAD_NAME;
	private static final String SHORTCUT = Messages.COMMAND_LOAD_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_LOAD_DETAILS;
	private static final String HELP = Messages.COMMAND_LOAD_HELP;
	
	private String fileName;
	
	public LoadCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length != 2) {
				throw new CommandParseException(Messages.INVALID_COMMAND_PARAMETERS);
			}
			
			this.fileName = commandWords[1];
			return this;
		}
		
		return null;
	}

	@Override
	public void execute(GameModel game, GameView view) throws CommandExecuteException {
		try {
			game.load(fileName);
			view.showGame();
		} catch(GameModelException gme) {
			throw new CommandExecuteException(Messages.ERROR_COMMAND_LOAD, gme);
		}	
	}

}
