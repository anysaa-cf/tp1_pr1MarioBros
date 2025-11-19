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
		super(game, pos, Action.LEFT, NAME, SHORTCUT);		
	}

	@Override
	protected void move() {
		if(isAlive()) {														
			if(isFalling()) {
				Position posBelow = new Position(getRow() + 1, getCol());
				if(!game.isInsideBounds(posBelow))			
					mushroomDies(); // goomba dies (for now) if it falls out of the map
				else
					updatePos(posBelow);	// if there is no ground below, it falls 1 cell	
			} else {			// if there is ground it moves horizontally
				int nextCol = getCol() + action.getY();
				int nextRow = getRow() + action.getX();
				Position nextPos = new Position(nextRow, nextCol);// get the next position given the action
				if(game.isInsideBounds(nextPos)) {
					updatePos(nextPos);
				} else {
					changeAction();
				}
			}
		}	
		
	}
	
	public void mushroomDies() {
		objectDies();
	}
	

	@Override
	public void update() {
		move();
		game.tryInteractionsFrom(this);
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
		Position returnPos = new Position(getRow() + 1, getCol());
		if(ground.isInPosition(returnPos)){
			updatePos(returnPos);
		}
		else {
			updatePos(new Position(getRow() - action.getX(), getCol() - action.getY()));
			changeAction();
		}
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
	public boolean receiveInteraction(Mushroom mushroom) {
		return false;
	}


	@Override
	public boolean receiveInteraction(Box box) {

		return false;
	}

}
