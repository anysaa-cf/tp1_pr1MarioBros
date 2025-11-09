package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class AddObjectCommand extends NoParamsCommand {
	
	private static final String NAME = Messages.COMMAND_ADD_OBJECT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_ADD_OBJECT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_ADD_OBJECT_DETAILS;
	private static final String HELP = Messages.COMMAND_ADD_OBJECT_HELP;
	
	public AddObjectCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public void execute(Game game, GameView view) {
		// TODO Auto-generated method stub
		
	}

}
