package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class Ground {
	private Position pos;
	private boolean isSolid;	// property of being a solid object
	
	public Ground(Position pos) {
		this.isSolid = true;
		this.pos = pos;
	}
	
	public String getIcon() {
		return Messages.LAND;
	}
	
	public boolean onPosition(Position position) {
		return this.pos.equals(position);
	}
	
	public void update() {
		
	}
}
