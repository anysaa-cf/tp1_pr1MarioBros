package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject {
	private Position pos;
	/*private Game game;
	 * private boolean alive = false;
	 */
	public ExitDoor(Game game,Position pos) {
		super(game, pos);
		this.pos = pos;
	}
	
	public String getIcon() {
		return Messages.EXIT_DOOR;		
	}
	
	// I have changed the onPosition(Position position) to isInPosition(Position p)
	public boolean isInPosition(Position position) {
		return this.pos.equals(position);
	}
	
	public void update() {
		
	}
}
