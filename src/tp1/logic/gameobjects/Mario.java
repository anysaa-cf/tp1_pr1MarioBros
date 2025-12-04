package tp1.logic.gameobjects;

import tp1.exceptions.GameModelException;
import tp1.logic.Action;
import tp1.logic.ActionList;
import tp1.logic.GameItem;
import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class Mario extends MovingObject {

	private ActionList actionList;
	private int life; // added recently, now that there is a Mario object in game, we can have life attribute here 
	private boolean big;
	
	private static final String NAME = Messages.MARIO_NAME;
	private static final String SHORTCUT = Messages.MARIO_SHORTCUT;
	
	public Mario(GameWorld game, Position pos) {
		super(game, pos, Action.RIGHT, NAME, SHORTCUT);
		this.actionList = new ActionList();
		this.big = true;
		this.life = 3;
	}

	public Mario() {
		super(null, null, Action.RIGHT, NAME, SHORTCUT);
	}

	public String getIcon() {
		String icon;
		
		switch(action) {
		case UP: 
		case DOWN: 
			icon = Messages.MARIO_STOP;
			break;
		case RIGHT:
			icon = Messages.MARIO_RIGHT;
			break;
		case LEFT:
			icon = Messages.MARIO_LEFT;
			break;
		default:
			icon = Messages.MARIO_STOP;
			break;
		}
		return icon;
	}
	
	public int marioLife() {
		return life;
	}
	
	public void update() {
		if(!actionList.isEmpty()) {
			while(!actionList.isEmpty()) {
				// mario moves according to the players actions
				move();	
				game.tryInteractionsFrom(this);
			}	
		} else {
			// automatic movement if there are no actions?¿
			move();
			game.tryInteractionsFrom(this);
		}
	}
	
	public void addAction(Action action) {
		this.actionList.addAction(action);
	}
	
	public boolean actionListIsEmpty() {
		return actionList.isEmpty();
	}
	
	public void addPoints(int newPoints) {
		game.addPoints(newPoints);
	}

	protected void move() {
		Position nextPos;
		if(isAlive()) {
			if(actionList.isEmpty()) {		// no more actions -> automatic movement
				nextPos = new Position(getRow() + action.getX(), getCol() + action.getY());
				if(game.isInsideBounds(nextPos))
					updatePos(nextPos); // automatic movement if there is no ground taken the last Action movement
			}
			else {		// actions -> movement declared by the player
				Action action = this.actionList.getAction();
				nextPos = new Position(getRow() + action.getX(), getCol() + action.getY());																					
			
				if(game.isInsideBounds(nextPos))
					updatePos(nextPos);
				this.action = action;
			}
		}
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
		updatePos(returnPos);
		return true;
	}

	@Override
	public boolean receiveInteraction(Mario mario) {
		return false;
	}

	@Override
	public boolean receiveInteraction(ExitDoor door) {
		game.marioExited();
		return true;
	}
	
	public void marioDies() {
		if(life <= 1) {
			life--;
			objectDies();
			game.marioDies();
		}
		else {
			if(big)
				this.big = false;
			else
				this.life--;
		}
	}
	
	@Override
	public boolean receiveInteraction(Goomba goomba) {
		if(!isFalling()) {
			marioDies();
			Position returnPos = new Position(getRow() - action.getX(), getCol() - action.getY()); 
			updatePos(returnPos);
		}
		else {
			goomba.goombaDies();
			game.addPoints(10);
		}
			
		return true;
	}

	public GameObject parse(String[] objWords, GameWorld game) throws GameModelException {
			if(matchObjectName(objWords[1].toLowerCase())) {
				if(objWords.length > 3) {
					String attributeMario = objWords[3].toLowerCase();
					
					if(attributeMario == Messages.MARIO_SMALL_NAME 
							|| attributeMario == Messages.MARIO_SMALL_SHORTCUT) {
						big = false;
					}
				}
				return super.parse(objWords, game);
			}
			return null;
	}
	
	public boolean isInPosition(Position p) {
		Position aux = new Position(p.getRow() + 1, p.getCol());
		return pos.equals(p) || big && pos.equals(aux);
	}

	@Override
	public boolean receiveInteraction(Mushroom mushroom) {
		this.big = true;
		mushroom.objectDies();
		return true;
	}


	@Override
	public boolean receiveInteraction(Box box) {
		Position returnPos = new Position(getRow() - action.getX(), getCol() - action.getY()); 
		updatePos(returnPos);
		if(action == Action.UP && !box.empty()) {
			box.empty();
			game.addPoints(50);
			game.addMushroom(new Position(box.getRow() - 1, box.getCol()));
		}
		return true;
	}
	
	@Override
	public GameObject create(GameWorld game, Position pos) {
		  Mario m = new Mario(game, pos);
		  m.action = this.action;
		  m.big = this.big;
		  return m;
	}
	
	public String toString() {
		String str = null;
		str = super.toString() + " " + (big ? Messages.MARIO_BIG_NAME : Messages.MARIO_SMALL_NAME);
		canWrite = false;
		return str;
	}

}