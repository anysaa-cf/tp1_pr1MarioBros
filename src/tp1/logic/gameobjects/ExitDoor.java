package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor {
	private Position pos;

	
	public ExitDoor(Position pos) {
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
