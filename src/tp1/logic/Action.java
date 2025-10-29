package tp1.logic;

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
	
	public static Action parseActionClass(String inputs) { // new parseAction method, simpler
		for(Action action : Action.values())
			if(action.name().equalsIgnoreCase(inputs) || action.abrev.equalsIgnoreCase(inputs))
				return action;
		return null;
	}
	
}
	
	
