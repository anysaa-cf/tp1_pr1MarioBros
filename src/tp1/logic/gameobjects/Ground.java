package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameItem;
import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class Ground extends GameObject {
	private static final String NAME = Messages.GROUND_NAME;
	private static final String SHORTCUT = Messages.GROUND_SHORTCUT;
	
	public Ground(Game game, Position pos) {
		super(game, pos, true, NAME, SHORTCUT);
	}
	
	public String getIcon() {
		return Messages.LAND;
	}
	
	public void update() {
	
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
		return true;
	}

	@Override
	public boolean receiveInteraction(Mushroom mushroom) {
		// TODO Auto-generated method stub
		return false;
	}

}
