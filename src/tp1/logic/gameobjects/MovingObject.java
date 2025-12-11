package tp1.logic.gameobjects;

import tp1.exceptions.GameModelException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Action;
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
		
		if(action == Action.DOWN && !solidObject)
			return true;
		else
			return false;
	}
	
	protected abstract void move() throws OffBoardException;
	
	
	public void changeAction() {
		action = action.changeAction(action);
	}
	
	public MovingObject parse (String objWords[], GameWorld game) throws GameModelException {
		
		MovingObject obj = (MovingObject) super.parse(objWords, game);
	
		if(objWords.length > 2 && matchObjectName(objWords[1].toLowerCase())) {
			this.action = (Action.parseActionClass(objWords[2].toLowerCase()));					
		}
		return obj;
	}
	
	public String toString() {
		String str = null;
		str = super.toString() + " " + action.toString();
		return str;
	}
}
