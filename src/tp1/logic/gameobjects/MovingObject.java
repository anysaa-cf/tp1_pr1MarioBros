package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.GameObject;
import tp1.logic.Position;

public abstract class MovingObject extends GameObject {
	private Action action;
	private boolean isAlive;
	boolean isFalling;

	public MovingObject(Game game, Position pos, Action action) {
		super(game, pos, false);
		this.isAlive = true;
		this.action = action;
		this.isFalling = isFalling();
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void objectDies() {
		isAlive = false;
	}
	
	private boolean isFalling() {
		Position nextPos = new Position(getRow() + 1, getCol());
		boolean ground = GameObjectContainer.isSolid(nextPos);
		
		if(ground && action != Action.DOWN)
			return false;
		else
			return true;
	}
	
	protected abstract void move();
}
