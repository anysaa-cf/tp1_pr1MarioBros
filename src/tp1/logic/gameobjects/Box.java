package tp1.logic.gameobjects;

import tp1.exceptions.GameModelException;
import tp1.logic.Action;
import tp1.logic.GameItem;
import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class Box extends GameObject {
	
	private boolean full;
	private static final String NAME = Messages.BOX_NAME;
	private static final String SHORTCUT = Messages.BOX_SHORTCUT;

	public Box(GameWorld game, Position pos) {
		super(game, pos, true, NAME, SHORTCUT);
		this.full = true;
	}

	public Box() {
		super(null, null, true, NAME, SHORTCUT);
	}

	@Override
	public boolean receiveInteraction(Mushroom mushroom) {
		
		return false;
	}

	public boolean isFull() {
		return this.full; 
	}
	
	public void empty() {
		this.full = false;
	}	
	
	public void update() {
		

	}

	@Override
	public String getIcon() {
		String icon;
		if(full)
			icon = Messages.BOX;
		else
			icon = Messages.EMPTY_BOX;
		
		return icon;
	}

	@Override
	public boolean interactWith(GameItem other) {
		boolean canInteract = this.isAlive() && other.isAlive() && other.isInPosition(new Position(getRow(), getCol()));
		if(canInteract) {
			other.receiveInteraction(this);
		}
		return canInteract;
	}

	@Override
	public boolean receiveInteraction(Ground ground) {
		
		return false;
	}

	@Override
	public boolean receiveInteraction(Mario mario) {
		
		return true;
	}

	@Override
	public boolean receiveInteraction(ExitDoor door) {
		
		return false;
	}

	@Override
	public boolean receiveInteraction(Goomba goomba) {
		
		return false;
	}

	@Override
	public boolean receiveInteraction(Box box) {
		
		return false;
	}
	
	public GameObject parse (String objWords[], GameWorld game) throws GameModelException {
		if(objWords.length > 2 && matchObjectName(objWords[1].toLowerCase())) {
			Box obj = (Box) super.parse(objWords, game);
			if(objWords[2].toLowerCase() == Messages.BOX_EMPTY 
					|| objWords[2].toLowerCase() == Messages.BOX_FULL_SHORTCUT)
				obj.empty();
			return obj;	
		}
		return null;		
	}

	@Override
	public GameObject create(GameWorld game, Position pos) {
		  Box b = new Box(game, pos);
		  b.full = this.full; 
		  return b;
	}
	
	public String toString() {
		String str = null;
		str = super.toString() + " " + (full ? Messages.BOX_FULL : Messages.BOX_EMPTY);
		return str;
	}

}
