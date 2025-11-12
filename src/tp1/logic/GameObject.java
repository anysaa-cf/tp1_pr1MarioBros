package tp1.logic;

import tp1.logic.gameobjects.*;

public abstract class GameObject implements GameItem {
	private Position pos; 
	private boolean isSolid;
	private boolean isAlive;
	protected Game game; 
	
	private final String name;
	private final String shortcut;
	
	public GameObject(Game game, Position pos, boolean bool, String name, String shortcut) {
		this.pos = pos;
		this.game = game;
		this.isSolid = bool;
		this.isAlive = true;
		this.name = name;
		this.shortcut = shortcut;
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
	
	public GameObject parse (String objWords[], GameWorld game) {
		
		if(objWords.length >= 3) {
			// each coordinate row and col counts as an element in the array
			int row, col;
			
			row = Integer.parseInt(objWords[0]);
			col = Integer.parseInt(objWords[1]);
			
			pos = new Position(row, col);
			
			String objType = objWords[2].toLowerCase();
			
			/*if(matchObjName(objType)) {		// create this method
				return this;
			}*/
		}
		
		return null;
	}
	
	

}
