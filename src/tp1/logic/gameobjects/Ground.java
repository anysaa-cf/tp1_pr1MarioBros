package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameObject;
import tp1.logic.Position;
import tp1.view.Messages;

public class Ground extends GameObject {

	public Ground(Game game, Position pos) {
		super(game, pos, true);
	}
	
	public String getIcon() {
		return Messages.LAND;
	}
	
	public void update() {
	
	}

	public boolean isAlive() {
		
		return false;
	}
}
