package tp1.control.commands;

import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;
import tp1.exceptions.ActionParseException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
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
			if(commandWords.length == 1) {
				throw new CommandParseException(Messages.INVALID_COMMAND_PARAMETERS);
			}
			for(int i = 1; i < commandWords.length; i++) { // from 0 to actionList length in order to read all the commands remaining from action command
				try {
					Action aux = Action.parseActionClass(commandWords[i]); // parse the action command into an action type
					ACTION.addAction(aux); // keep that command already being an action type and increase the counter for the next action space					
				} catch (ActionParseException ape) {
					throw new CommandParseException(Messages.INVALID_COMMAND_PARAMETERS, ape);
				}
			}
			return this;
		}
		return null; 
	}
	
	@Override
	public void execute(GameModel game, GameView view) throws CommandExecuteException { // here we add ACTION in the game
		try{
			while(!ACTION.isEmpty()) { // for every value of the action list
				game.addAction(ACTION.getAction()); // here we add the action list to the game. This is what an action command does
			}
			game.update();
			view.showGame();
		} catch (GameModelException gme) {
			throw new CommandExecuteException(Messages.ERROR_COMMAND_EXECUTE, gme);
		}
	}
}
