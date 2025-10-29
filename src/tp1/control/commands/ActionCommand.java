package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;
import tp1.logic.Action; // needed to create a type Action

public class ActionCommand extends AbstractCommand{
	
	private Action[] ACTION; // it's an actionCommand which must be identified by what action is; up, left, down, etc...
	private static final String NAME = Messages.COMMAND_ACTION_NAME;
	private static final String SHORTCUT = Messages.COMMAND_ACTION_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_ACTION_DETAILS;
	private static final String HELP = Messages.COMMAND_ACTION_HELP;
	
	public ActionCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP); 
	}
	
	@Override
	public Command parse(String[] commandWords) { // here we recognize what action is
		if(matchCommandName(commandWords[0])) { // if the first command is action
			ACTION = new Action[commandWords.length - 1]; // create a list of actions as big as the length of next commands
			int a = 0; // initialize a local counter for action list
			for(int i = 0; i < ACTION.length - 1; i++) { // from 0 to actionList length in order to read all the commands remaining from action command
				Action aux = Action.parseActionClass(commandWords[i]); // parse the action command into and action type
				if(aux != null) // if it's actually a valid command for actions
					ACTION[a++] = aux; // keep that command already being an action type and increase the counter for the next action space
			}
			return this;// if the first command is action, we return an actionCommand object with all the actions parsed
		} 
		return null; //if it's not an action, return null
	}
	
	@Override
	public void execute(Game game, GameView view){ // here we add ACTION in the game
		for(Action action: ACTION) // for every value of the action list
			game.addAction(action); // here we add the action list to the game. This is what an action command does
	}

	public String helpText() {
		return DETAILS + ": " + HELP;
	}

}
