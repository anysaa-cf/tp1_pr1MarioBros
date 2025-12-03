package tp1.logic;

import tp1.exceptions.GameModelException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.PositionParseException;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public abstract class GameObject implements GameItem {
	protected Position pos; 		// protected or private?¿
	private boolean isSolid;
	private boolean isAlive;
	protected GameWorld game; 
	protected boolean canWrite = true;
	
	private final String name;
	private final String shortcut;
	
	public GameObject(GameWorld game, Position pos, boolean bool, String name, String shortcut) {
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
	public abstract GameObject create(GameWorld game, Position pos);
	
	abstract public boolean interactWith(GameItem other);
	abstract public boolean receiveInteraction(Ground ground);
	abstract public boolean receiveInteraction(Mario mario);
	abstract public boolean receiveInteraction(ExitDoor door);
	abstract public boolean receiveInteraction(Goomba goomba);
	
	public GameObject parse (String objWords[], GameWorld game) throws GameModelException{
		if(matchObjectName(objWords[1].toLowerCase())) {
			pos = Position.parsePosition(objWords[0]);
			this.game = game;
			return create(game, pos);
		}
		return null;
	}
	
	protected String getName() { return name; }
	protected String getShortcut() { return shortcut; }
	
	protected boolean matchObjectName(String nameObject) {
		return getShortcut().equalsIgnoreCase(nameObject) ||
				getName().equalsIgnoreCase(nameObject);
	}
	
	public String toString() {
		String str = null;
		str = pos.toString() + name;
		return str;
	}
	

}
