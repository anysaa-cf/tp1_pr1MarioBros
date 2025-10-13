package tp1.logic;

import tp1.view.ViewInterface;
import tp1.view.Messages;
import tp1.logic.gameobjects.Mario;

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
			if(aux1++ < 5 && aux2 == 0) // no opposite actions can be executed in the same cycle
				return RIGHT;
			break;
			
		case Messages.ACTION_LEFT:
		case Messages.ACTION_LEFT_SHORTCUT:
			if(aux2++ < 5 && aux1 == 0)
				return LEFT;
			break;
		
		case Messages.ACTION_UP:
		case Messages.ACTION_UP_SHORTCUT:
			if(aux3++ < 5 && aux4 == 0)
				return UP;
			break;
			
		case Messages.ACTION_DOWN:
		case Messages.ACTION_DOWN_SHORTCUT:
			if(aux4++ < 5 && aux3 == 0)
				return DOWN;
			break;
		
				
		case Messages.ACTION_STOP:
		case Messages.ACTION_STOP_SHORTCUT:
			if(aux5++ < 5)
				return STOP;
			break;
				
		default:
		}
		return null;
	}
}
	
	
	//TODO fill your code
	
