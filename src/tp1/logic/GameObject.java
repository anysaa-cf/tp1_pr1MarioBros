package tp1.logic;

import tp1.logic.gameobjects.*;

public abstract class GameObject implements GameItem {
	private Position pos; 
	private boolean isSolid;
	private boolean isAlive;
	protected GameWorld game; 
	
	private final String name;
	private final String shortcut;
	
	public GameObject(GameWorld game2, Position pos, boolean bool, String name, String shortcut) {
		this.pos = pos;
		this.game = game2;
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
		if(objWords.length >= 2) {
			// each coordinate row and col counts as an element in the array
			int row, col;
			
			String aux = objWords[0].replaceAll("[()\\s]", ""); // deletes '(', ')' and spaces
	        String[] parts = aux.split(",");
			
	        row = Integer.parseInt(parts[0]);
	        col = Integer.parseInt(parts[1]);
	        
			pos = new Position(row, col);
			updatePos(pos);
			
			this.game = game;
			
			String objType = objWords[1].toLowerCase();
			
			if(matchObjectName(objType)) {
				return this;
			}
		}
		
		return null;
	}
	
	protected String getName() { return name; }
	protected String getShortcut() { return shortcut; }
	
	protected boolean matchObjectName(String nameObject) {
		return getShortcut().equalsIgnoreCase(nameObject) ||
				getName().equalsIgnoreCase(nameObject);
	}
	

}
