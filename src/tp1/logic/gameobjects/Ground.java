package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Ground extends GameObject {
	private Position pos;
	private boolean isSolid;	// property of being a solid object
	/*private Game game;
	 * private boolean alive = false;
	 */
	
	public Ground(Game game, Position pos) {
		super(game, pos);
		this.isSolid = true;
		this.pos = pos;
	}
	
	public String getIcon() {
		return Messages.LAND;
	}
	
	// I have changed the onPosition(Position position) to isInPosition(Position p)
	public boolean isInPosition(Position position) {
		return this.pos.equals(position);
	}
	
	public void update() {
		
	}
}
