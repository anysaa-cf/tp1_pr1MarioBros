package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.GameItem;
import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class Goomba extends MovingObject {
	
	private static final String NAME = Messages.GOOMBA_NAME;
	private static final String SHORTCUT = Messages.GOOMBA_SHORTCUT;
	
	public Goomba(Game game, Position pos) {
		super(game, pos, Action.RIGHT, NAME, SHORTCUT);		// action.left?¿
	}
	
	public String getIcon() {
		return Messages.GOOMBA;		
	}
	
	protected void move() {
		if(isAlive()) {														
			if(isFalling()) {
				Position posBelow = new Position(getRow() + 1, getCol());
				if(!game.isInsideBounds(posBelow))			
					goombaDies(); // goomba dies (for now) if it falls out of the map
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
	
	private void changeAction() {
		if(action == Action.RIGHT) {
			action = Action.LEFT;
		} else if(action == Action.LEFT) {
			action = Action.RIGHT;
		}	
	}
	
	public void update() {
		move();
		game.tryInteractionsFrom(this);
	}

	public void goombaDies() {
		objectDies();
	}

	@Override
	public boolean interactWith(GameItem other) {
		boolean canInteract = this.isAlive() && other.isAlive() && other.isInPosition(new Position(this.getRow(), this.getCol()));
		if(canInteract && game.isDifferent(other, this)) {
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
		if(mario.isFalling())
			goombaDies();
		return true;
	}

	@Override
	public boolean receiveInteraction(ExitDoor door) {
		return false;
	}

	@Override
	public boolean receiveInteraction(Goomba goomba) {
		this.changeAction();
		move();
		goomba.changeAction();
		return true;
	}

}
