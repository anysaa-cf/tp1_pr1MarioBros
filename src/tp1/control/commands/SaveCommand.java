package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class SaveCommand extends AbstractCommand {
	
	private static final String NAME = Messages.COMMAND_SAVE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SAVE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SAVE_DETAILS;
	private static final String HELP = Messages.COMMAND_SAVE_HELP;
	
	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public void execute(GameModel game, GameView view) throws CommandExecuteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Command parse(String[] parameter) throws CommandParseException {
		// TODO Auto-generated method stub
		return null;
	}

}
