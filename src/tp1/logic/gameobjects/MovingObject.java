package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.GameObject;
import tp1.logic.Position;

public abstract class MovingObject extends GameObject {
	protected Action action;
	private boolean isFalling;
	
	public MovingObject(Game game, Position pos, Action action, String name, String shortcut) {
		super(game, pos, false, name, shortcut);
		this.action = action;
		this.isFalling = isFalling();
	}
	
	public boolean isFalling() {
		Position nextPos = new Position(getRow() + 1, getCol());
		boolean solidObject = game.isSolid(nextPos);
		
		if(solidObject && action != Action.DOWN)
			return false;
		else
			return true;
	}
	
	protected abstract void move();
}
