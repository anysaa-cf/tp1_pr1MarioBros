package tp1.logic;

import tp1.view.Messages;

/**
 * Represents the allowed actions in the game
 *
 */
public enum Action {
	LEFT(0,-1), RIGHT(0,1), DOWN(1,0), UP(-1, 0), STOP(0,0);

	private int x;
	private int y;
	
	
	private Action(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public static Action parseActions(String inputs) {
		int aux1 = 0, aux2= 0, aux3 = 0, aux4 = 0, aux5 = 0; // counters for up to 4 occurrences of each action
			
		switch(inputs) {
		
		case Messages.ACTION_RIGHT:
		case Messages.ACTION_RIGHT_SHORTCUT:
			if(aux1++ <= ActionList.maxActions && aux2 == 0) // no opposite actions can be executed in the same cycle
				return Action.RIGHT;
			break;
			
		case Messages.ACTION_LEFT:
		case Messages.ACTION_LEFT_SHORTCUT:
			if(aux2++ <= ActionList.maxActions && aux1 == 0)
				return Action.LEFT;
			break;
		
		case Messages.ACTION_UP:
		case Messages.ACTION_UP_SHORTCUT:
			if(aux3++ <= ActionList.maxActions && aux4 == 0)
				return Action.UP;
			break;
			
		case Messages.ACTION_DOWN:
		case Messages.ACTION_DOWN_SHORTCUT:
			if(aux4++ <= ActionList.maxActions && aux3 == 0)
				return Action.DOWN;
			break;
		
				
		case Messages.ACTION_STOP:
		case Messages.ACTION_STOP_SHORTCUT:
			if(aux5++ <= ActionList.maxActions)
				return Action.STOP;
			break;
				
		default:
		}
		return null;
	}
	
}
	
	
