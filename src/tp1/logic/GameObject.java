package tp1.logic;

import tp1.logic.gameobjects.*;

public abstract class GameObject implements GameItem {
	private Position pos; 
	private boolean isSolid;
	private boolean isAlive;
	protected Game game; 
	
	public GameObject(Game game, Position pos, boolean bool) {
		this.pos = pos;
		this.game = game;
		this.isSolid = bool;
		this.isAlive = true;
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
	
	public void objectDies() {
		isAlive = false;
	}
	
	public boolean isAlive() {
		return this.isAlive;
	}
	
	public boolean isInPosition(Position p) {
		return pos.equals(p);
	}
	
	public boolean isSolid() {
		return isSolid;
	}
	
	public abstract void update();
	public abstract String getIcon();
	
	abstract public boolean interactWith(GameItem other);
	abstract public boolean receiveInteraction(Ground ground);
	abstract public boolean receiveInteraction(Mario mario);
	abstract public boolean receiveInteraction(ExitDoor door);
	abstract public boolean receiveInteraction(Goomba goomba);

}
