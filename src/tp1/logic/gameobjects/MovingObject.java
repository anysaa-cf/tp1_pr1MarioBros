package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;

public abstract class MovingObject extends GameObject{
	private Action action;
	boolean isFalling = false;

	public MovingObject(Game game, Position pos) {
		super(game, pos);
	}

}
