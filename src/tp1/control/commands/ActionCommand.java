package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;
import tp1.exceptions.CommandParseException;
import tp1.logic.Action;
import tp1.logic.ActionList;

public class ActionCommand extends AbstractCommand{
	
	private ActionList ACTION; // it's an actionCommand which must be identified by what action is; up, left, down, etc...
	private static final String NAME = Messages.COMMAND_ACTION_NAME;
	private static final String SHORTCUT = Messages.COMMAND_ACTION_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_ACTION_DETAILS;
	private static final String HELP = Messages.COMMAND_ACTION_HELP;
	
	public ActionCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP); 
		ACTION = new ActionList();
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException { // it will catch the actionParseException here
		if(matchCommandName(commandWords[0])) { // if the first command is action
			for(int i = 1; i < commandWords.length; i++) { // from 0 to actionList length in order to read all the commands remaining from action command
				Action aux = Action.parseActionClass(commandWords[i]); // parse the action command into an action type
				ACTION.addAction(aux); // keep that command already being an action type and increase the counter for the next action space
			}
			return this;// if the first command is action, we return an actionCommand object with all the actions parsed
		}
		return null; 
	}
	
	@Override
	public void execute(Game game, GameView view){ // here we add ACTION in the game
		while(!ACTION.isEmpty()) // for every value of the action list
			game.addAction(ACTION.getAction()); // here we add the action list to the game. This is what an action command does
		game.update();
		view.showGame();
	}

	public String helpText() {
		return DETAILS + ": " + HELP;
	}

}
