package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class Ground {
	private Position pos;
	private boolean isSolid = false;	// property of being a solid object
	
	public Ground(Position pos) {
		isSolid = true;
		this.pos = pos;
	}
	
	public String getIcon() {
		return Messages.LAND;
	}
	
	public void update() {
		
	}
}
