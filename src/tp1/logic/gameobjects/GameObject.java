package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;

public abstract class GameObject implements GameItem {
	private Position pos; // If you can, make it private.	protected Position pos;
	private boolean isSolid;
	protected Game game; 
	
	public GameObject(Game game, Position pos, boolean bool) {
		this.pos = pos;
		this.game = game;
		this.isSolid = bool;
	}
	
	public boolean isInPosition(Position p) {
		return pos.equals(p);
	}
	
	// TODO implement and decide, Which one is abstract?
	
	public boolean isSolid() {
		return isSolid;
	}
	
	public abstract void update();
	public abstract String getIcon();
	
	public boolean interactWith(GameItem other) {
		//TODO
		return false;
	}	
	public boolean receiveInteraction(Ground ground) {
		//TODO
		return false;
	}
	public boolean receiveInteraction(Mario mario) {
		//TODO
		return false;
	}
	public boolean receiveInteraction(ExitDoor door) {
		//TODO
		return false;
	}
	public boolean receiveInteraction(Goomba goomba) {
		//TODO
		return false;
	}

}
