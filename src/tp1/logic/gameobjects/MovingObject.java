package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.logic.Position;

public abstract class MovingObject extends GameObject {
	protected Action action;
	
	public MovingObject(GameWorld game, Position pos, Action action, String name, String shortcut) {
		super(game, pos, false, name, shortcut);
		this.action = action;
	}
	
	public boolean isFalling() {
		// if we want to add an obj and game == null or pos == null
		if(game == null || pos == null || !isAlive()) {
			return false;
		}
		
		Position nextPos = new Position(getRow() + 1, getCol());
		boolean solidObject = game.isSolid(nextPos);
		
		if(solidObject && action != Action.DOWN)
			return false;
		else
			return true;
	}
	
	protected abstract void move();
	
	public GameObject parse (String objWords[], GameWorld game) {
		if(objWords.length > 2) {
			this.action = (Action.parseActionClass(objWords[2].toLowerCase()));					
		}
		return super.parse(objWords, game);		
	}
}
