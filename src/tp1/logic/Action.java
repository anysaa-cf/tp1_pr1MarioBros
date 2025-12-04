package tp1.logic;

import tp1.exceptions.ActionParseException;
import tp1.exceptions.CommandParseException;
import tp1.view.Messages;

/**
 * Represents the allowed actions in the game
 *
 */
public enum Action {
	LEFT(0,-1, Messages.ACTION_LEFT_SHORTCUT), 
	RIGHT(0,1, Messages.ACTION_RIGHT_SHORTCUT), 
	DOWN(1,0, Messages.ACTION_DOWN_SHORTCUT), 
	UP(-1, 0, Messages.ACTION_UP_SHORTCUT), 
	STOP(0,0, Messages.ACTION_STOP_SHORTCUT); // we want to have another attribute for each value of the enum type for actions since it can be helpful for parsing actions

	private int x;
	private int y;
	private String abrev;
	
	private Action(int x, int y, String c) {
		this.x=x;
		this.y=y;
		this.abrev = c;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	// modify this: throw ActionParseException and in the ActionCommand catch this type of exception
	public static Action parseActionClass(String inputs) throws ActionParseException { 
		for(Action action : Action.values())
			if(action.name().equalsIgnoreCase(inputs) || action.abrev.equalsIgnoreCase(inputs))
				return action;
		throw new ActionParseException(Messages.UNKNOWN_ACTION.formatted(inputs));
	}
	
	public Action changeAction(Action action) {
		if(action == RIGHT || action == DOWN) {
			return LEFT;
		} else if(action == LEFT) {
			return RIGHT;
		}
		return STOP;	
	}
	
	public String toString() {
		return abrev;
	}	
	
}
	
	
