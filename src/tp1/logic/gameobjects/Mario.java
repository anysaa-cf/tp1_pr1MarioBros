package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Mario {

	private Position pos;
	private boolean isSolid = false;	// property of being a solid object
	
	public Mario(Position pos) {
		this.pos = pos;
	}
	
	public String getIcon() {
		
		// if direction is right then Messages.MARIO_RIGHT
		// if direction is left then Messages.MARIO_LEFT
		
		return null;		// change
	}
	
	/**
	 *  Implements the automatic update	
	 */
	public void update() {
		//TODO fill your code
	}
}
