package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;
import tp1.logic.Action; // needed to create a type Action

public class ActionCommand extends AbstractCommand{
	
	private Action ACTION; // it's an actionCommand which must be identified by what action is; up, left, down, etc...
	private static final String NAME = Messages.COMMAND_ACTION_NAME;
	private static final String SHORTCUT = Messages.COMMAND_ACTION_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_ACTION_DETAILS;
	private static final String HELP = Messages.COMMAND_ACTION_HELP;
	
	public ActionCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP); 
	}
	
	@Override
	public Command parse(String[] commandWords) { // here we recognize what action is
		
	//ACTION.parseActions(commandWords[0]) something like this must be declared, maybe using a loop
		
		return null;
	}
	
	@Override
	public void execute(Game game, GameView view){ // here we add ACTION in the game
		game.addAction(ACTION); // here we add the action to the game, that is what an action command does
	}

	public String helpText() {
		return DETAILS + ": " + HELP;
	}

}
