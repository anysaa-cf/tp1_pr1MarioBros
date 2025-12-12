package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.GameItem;
import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class Goomba extends MovingObject {
	
	private static final String NAME = Messages.GOOMBA_NAME;
	private static final String SHORTCUT = Messages.GOOMBA_SHORTCUT;
	
	public Goomba(GameWorld game, Position pos) {
		super(game, pos, Action.RIGHT, NAME, SHORTCUT);		
	}
	
	public Goomba() {
		super(null, null, Action.RIGHT, NAME, SHORTCUT);
	}

	public String getIcon() {
		return Messages.GOOMBA;		
	}
	
	protected void move() {
		if(isAlive()) {														
			Position posBelow = new Position(getRow() + 1, getCol());
			if(!game.isInsideBounds(posBelow))			
				goombaDies(); 
			else if(!game.isSolid(posBelow)) {
				updatePos(posBelow);
				action = Action.DOWN;
			}else {	
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
	public void update() {
		move();
		game.tryInteractionsFrom(this);
	}

	public void goombaDies() {
		objectDies();
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
		Position returnPos = new Position(getRow() - action.getX(), getCol() - action.getY());
		if(ground.isInPosition(pos)){
			updatePos(returnPos);
			changeAction();
			update();
			return true;
		}
		return false;
	}

	@Override
	public boolean receiveInteraction(Mario mario) {
		goombaDies();
		return true;
	}

	@Override
	public boolean receiveInteraction(ExitDoor door) {
		return false;
	}

	@Override
	public boolean receiveInteraction(Goomba goomba) {
		updatePos(new Position(getRow() - action.getX(), getCol() - action.getY()));
		changeAction();
		return true;
	}

	@Override
	public boolean receiveInteraction(Mushroom mushroom) {
		updatePos(new Position(getRow() - action.getX(), getCol() - action.getY()));
		changeAction();
		return true;
	}

	@Override
	public boolean receiveInteraction(Box box) {
		
		return false;
	}
	
	@Override
	public GameObject create(GameWorld game, Position pos) {
		  Goomba g = new Goomba(game, pos);
		  g.action = this.action;
		  return g;
	}

}
