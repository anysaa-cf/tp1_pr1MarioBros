package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameLoadException;
import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class ResetCommand extends AbstractCommand {
	
    private static final String NAME = Messages.COMMAND_RESET_NAME;
    private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
    private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
    private static final String HELP = Messages.COMMAND_RESET_HELP;

    private Integer level = null;
    
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(matchCommandName(commandWords[0])) {
			// reset with no parameters
			if(commandWords.length == 1) {
				this.level = null;
				return this;
			} else if (commandWords.length == 2) {		// reset with parameters
				try {
					this.level = Integer.parseInt(commandWords[1]);
					return this;				
				} catch (NumberFormatException nfe) {		// low-level exception
					throw new CommandParseException(Messages.LEVEL_NOT_A_NUMBER_ERROR.formatted(commandWords[1]), nfe);	
				}	
			} else {
				// commandWords.length > 2
				throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
			}
		}		
		
		return null;
	}

	@Override
	public void execute(GameModel game, GameView view) throws CommandExecuteException {
		try {
			if(level == null) {
				game.reset();
			} else {
				game.setLevel(level);
				game.initGame();
			}
			
			view.showGame();
		}catch(GameLoadException gle) {
			throw new CommandExecuteException(gle);
		}
	}
}
