package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.GameItem;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class Mushroom extends MovingObject {

	private static final String NAME = Messages.MUSHROOM_NAME;
	private static final String SHORTCUT = Messages.MUSHROOM_SHORTCUT;
	
	public Mushroom(GameWorld game, Position pos) {
		super(game, pos, Action.RIGHT, NAME, SHORTCUT);
	}

	@Override
	protected void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getIcon() {
		return Messages.MUSHROOM;
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
		this.objectDies(); 		// mushroom disappears
		
		
		
		
		return false;
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
	public boolean receiveInteraction(Mushroom mushroom) {
		// TODO Auto-generated method stub
		return false;
	}

}
