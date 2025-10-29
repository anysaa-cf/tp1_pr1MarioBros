package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject {
	private Position pos;
	private Game game;
	
	public ExitDoor(Game game,Position pos) {
		super(game, pos, false);
		this.pos = pos;
	}
	
	public String getIcon() {
		return Messages.EXIT_DOOR;		
	}

	public boolean isInPosition(Position position) {
		return this.pos.equals(position);
	}
	
	public void update() {
		
	}

	public boolean isAlive() {

		return false;
	}
}
