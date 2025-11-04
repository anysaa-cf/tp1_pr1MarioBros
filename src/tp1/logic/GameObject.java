package tp1.logic;

import tp1.logic.gameobjects.*;

public abstract class GameObject implements GameItem {
	private Position pos; 
	private boolean isSolid;
	protected Game game; 
	
	public GameObject(Game game, Position pos, boolean bool) {
		this.pos = pos;
		this.game = game;
		this.isSolid = bool;
	}
	
	public void updatePos(Position pos) {
		this.pos = pos;
	}
	
	public int getRow() {
		return pos.getRow();
	}
	
	public int getCol() {
		return pos.getCol();
	}
	
	public boolean isInPosition(Position p) {
		return pos.equals(p);
	}
	
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
