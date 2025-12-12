package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.GameItem;
import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class FireBall extends MovingObject {
	
	private static final String name = Messages.FIRE_NAME;
	private static final String shortcut = Messages.FIRE_SHORTCUT;
	private boolean previousUp = false;
	private int counter = 0;

	public FireBall(GameWorld game, Position pos) {
		super(game, pos, Action.RIGHT, name, shortcut);
		enableThrow();
	}
	
	public FireBall() {
		super(null, null, Action.RIGHT, name, shortcut);
		enableThrow();
	}

	@Override
	public boolean receiveInteraction(Mushroom mushroom) {
		mushroom.objectDies();
		return true;
	}

	@Override
	public boolean receiveInteraction(Box box) {
		objectDies();
		return true;
	}
	
	public void setAction(Action a) {
		action = a;
	}

	@Override
	protected void move() {
		if(isAlive()) {														
			int nextCol = getCol() + action.getY();
			int nextRow = getRow() + action.getX();
			Position nextPos = new Position(nextRow, nextCol);
			if(previousUp) {
				nextCol = nextPos.getCol() + Action.DOWN.getY();
				nextRow = nextPos.getRow() + Action.DOWN.getX();
				nextPos = new Position (nextRow, nextCol);
				previousUp = !previousUp;
			}
			else {
				nextCol = nextPos.getCol() + Action.UP.getY();
				nextRow = nextPos.getRow() + Action.UP.getX();
				nextPos = new Position (nextRow, nextCol);
				previousUp = !previousUp;
			}
			if(game.isInsideBounds(nextPos) && counter < 15) {
				updatePos(nextPos);
				counter++;
			}
			else {
				counter = 0;
				objectDies();
			}
		}	

	}

	@Override
	public void update() {
		if(isAlive()) {
			move();
			game.tryInteractionsFrom(this);
		}

	}

	@Override
	public String getIcon() {
		
		return Messages.FIRE;
	}

	@Override
	public GameObject create(GameWorld game, Position pos) {
		  FireBall b = new FireBall(game, pos);
		  b.action = Action.RIGHT;
		  return b;
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
		if(previousUp) {
				updatePos(new Position(getRow() - action.getX() + Action.DOWN.getX(), getCol() - action.getY() + Action.DOWN.getY()));
				if(game.isSolid(pos))
					updatePos(new Position(getRow() - action.getX() + Action.UP.getX(), getCol() - action.getY() + Action.UP.getY()));
				changeAction();
		}		
		else {
			updatePos(new Position(getRow() - action.getX() + Action.UP.getX(), getCol() - action.getY() + Action.UP.getY()));
				if(game.isSolid(pos))
					updatePos(new Position(getRow() - action.getX() + Action.DOWN.getX(), getCol() - action.getY() + Action.DOWN.getY()));
				changeAction();
		}
		
		return true;
	}

	@Override
	public boolean receiveInteraction(Mario mario) {
		mario.marioHit();
		objectDies();
		return true;
	}

	@Override
	public boolean receiveInteraction(ExitDoor door) {
		objectDies();
		return true;
	}

	@Override
	public boolean receiveInteraction(Goomba goomba) {
		goomba.goombaDies();
		objectDies();
		return true;
	}
	
	public boolean receiveInteraction(FireBall fireball) {
		fireball.objectDies();
		objectDies();
		return true;
	}

}
