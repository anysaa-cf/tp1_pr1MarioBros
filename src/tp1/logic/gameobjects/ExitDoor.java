package tp1.logic.gameobjects;

import tp1.logic.GameItem;
import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;


public class ExitDoor extends GameObject {
	private static final String NAME = Messages.EXITDOOR_NAME;
	private static final String SHORTCUT = Messages.EXITDOOR_SHORTCUT;
	
	public ExitDoor(GameWorld game, Position pos) {
		super(game, pos, false, NAME, SHORTCUT);
	}
	
	public String getIcon() {
		return Messages.EXIT_DOOR;		
	}
	
	public void update() {
		//Leave empty
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
		game.win();
		objectDies();
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
	public boolean receiveInteraction(Mushroom mushroom) {
		
		return false;
	}

	@Override
	public boolean receiveInteraction(Box box) {

		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public GameObject create(GameWorld game, Position pos) {
		  ExitDoor d = new ExitDoor(game, pos); 
		  return d;
	}

}
