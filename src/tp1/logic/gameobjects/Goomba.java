package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Goomba {
	private Position pos;
	private boolean isSolid = false;	// property of being a solid object
	private boolean isMobile = false;
	
	public Goomba(Game game, Position pos) {
		isMobile = true;
		this.pos = pos;
	}
	
	public String getIcon() {
		return Messages.GOOMBA;		
	}
	
	public boolean isGoombaInPosition(Position position) {	// check if current goomba position is in the position passed by argument
		return this.pos.equals(position);
	}
	
	public void update() {
		
	}
}
