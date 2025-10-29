package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;

public abstract class MovingObject extends GameObject {
	private Action action;
	private boolean isAlive;
	boolean isFalling = false;

	public MovingObject(Game game, Position pos) {
		super(game, pos, false);
		this.isAlive = true;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void objectDies() {
		isAlive = false;
	}
	
	protected abstract void move();
}
