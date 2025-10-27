package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;

// contains the methods implementing basic movements (behavior and state of the objects)
// to be used by its subclasses mario and goomba
public abstract class MovingObject extends GameObject {
	private Action action;
	boolean isFalling = false;

	public MovingObject(Game game, Position pos) {
		super(game, pos);
	}
	
	// maybe i could implement the functions of isSolid and isAlive from the GameObject here?¿

}
