package tp1.logic.gameobjects;

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

	@Override
	public boolean receiveInteraction(Mushroom mushroom) {
		
		return false;
	}

	public boolean empty() {
		boolean aux = this.full;
		this.full = false;
		return !aux;
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
	
	public GameObject parse (String objWords[], GameWorld game) {
		if(objWords.length > 2) {
			this.full = (objWords[2].toLowerCase() == Messages.BOX_FULL ? true : objWords[2].toLowerCase() == Messages.BOX_FULL_SHORTCUT ? true : false);					
		}
		return super.parse(objWords, game);		
	}

	@Override
	public GameObject create(GameWorld game, Position pos) {
		  Box b = new Box(game, pos);
		  b.full = this.full; 
		  return b;
	}

}
