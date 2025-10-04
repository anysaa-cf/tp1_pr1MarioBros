package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor {
	private Position pos;
	private boolean isSolid = false;	// property of being a solid object
	
	public ExitDoor(Position pos) {
		// isSolid = false, no need to write the same here
		this.pos = pos;
	}
	
	public String getIcon() {
		return Messages.EXIT_DOOR;		
	}
	
	public boolean isExitDoorInPosition(Position position) {	// check if current exitDoor position is in the position passed by argument
		return this.pos.equals(position);
	}
	
	public void update() {
		
	}
}
