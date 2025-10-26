package tp1.logic.gameobjects;

import tp1.logic.ActionList;
import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Mario extends MovingObject {

	private Position pos;
	private Action lastAction;
	private ActionList actionList;
	private Game game;
	private int rightC, leftC, upC, downC;

	private boolean big = true;		
	private boolean alive = true;
//	private boolean isMobile = true;
	
	public Mario(Game game, Position pos) {
		super(game, pos);
		this.pos = pos;
		this.game = game;
		this.lastAction = Action.RIGHT;
		this.actionList = new ActionList();
		rightC = leftC = upC = downC = 0;
	}
	
	public String getIcon() {
		String icon;
		
		switch(lastAction) {
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

	public void update() {
		Position nextPos;
		boolean ground;
		
			if(actionList.isEmpty()) {		// no more actions -> automatic movement
				nextPos = new Position(pos.getRow() + lastAction.getX(), pos.getCol() + lastAction.getY());
				 ground = game.getGameObjects().areGroundsInPosition(nextPos);
				
				if(!ground && game.isInsideBounds(nextPos))
					pos = nextPos; // automatic movement if there is no ground taken the last Action movement
			}
			else {		// actions -> movement declared by the player
				Action action = this.actionList.getAction();
				nextPos = new Position(pos.getRow() + action.getX(), pos.getCol() + action.getY());
				 ground = game.getGameObjects().areGroundsInPosition(nextPos);
			
				if(!ground && game.isInsideBounds(nextPos))
					switch(action) {
				
					case Action.RIGHT:
						pos = nextPos;
						break;
					
					case Action.LEFT:
						pos = nextPos;
						break;
				
					case Action.UP:
						pos = nextPos;
						break;
				
					case Action.DOWN:
						pos = nextPos;	
						break;
					
					default:
						break;
					}
				lastAction = action;
			}	
			game.doInteractionsFrom(this);
	}
	
	public void marioDies() {
		if(alive) {
			game.hit();
			if(game.numLives() <= 0) {
				alive = false;
				game.marioDies();
			}
		}
	}
	
	// I have changed the onPosition(Position position) to isInPosition(Position p)
	public boolean isInPosition(Position position) {		
		return (this.pos.equals(position) || 
				(big && this.pos.equals(new Position(position.getRow() + 1, position.getCol()))));
	}
	public void addAction(Action action) {
		if(updateC(action))
			this.actionList.addAction(action);
	}
	
	public boolean actionListIsEmpty() {
		return actionList.isEmpty();
	}
	
	 public boolean updateC(Action action) {
		 boolean ok = false;
		 switch(action) {
		 
		 	case RIGHT:
		 		if(leftC == 0 && rightC < ActionList.maxActions)
		 			ok = true;
		 			rightC++;
		 		break;
		 	
		 	case LEFT:
		 		if(rightC == 0 && leftC < ActionList.maxActions)
		 			ok = true;
		 			leftC++;
				 break;
			
		 	case UP:
		 		if(downC == 0 && upC < ActionList.maxActions)
		 			ok = true;
		 			upC++;
				 break;
				 
		 	case DOWN:
		 		if(upC == 0 && downC < ActionList.maxActions)
		 			ok = true;
		 			downC++;
				 break;
			
		 	case STOP:
		 		ok = true; // infinite stops
		 		break;
				 
		 	default:
		 		break;
		 }
		 return ok;
	 }
	 
	 public void restartC() {
		 rightC = leftC = upC = downC = 0;
	 }
	 
	 public boolean interactWith(ExitDoor other) {
		 return other.isInPosition(this.pos);			// check if exitDoor and mario are on the same position
	 }
	 
	 public void interactWith(Goomba other) {
		 if (other.isInPosition(this.pos))	{		// check if goomba and mario are on the same position
			 boolean falling = isFalling();
			 
			 if(falling)	// if mario is falling and a goomba is below him, the goomba dies
				 other.receiveInteraction(this);				 
			 else {			// mario collides laterally with a goomba
				 if(big)
					 big = false;
				 else 
					 marioDies();
			 }
		 }
	 }

	private boolean isFalling() {
		Position nextPos = new Position(pos.getRow() + 1, pos.getCol());
		boolean ground = game.getGameObjects().areGroundsInPosition(nextPos);
		
		if(ground && lastAction != Action.DOWN)
			return false;
		else
			return true;
	}
	
	public void addPoints(int newPoints) {
		game.addPoints(newPoints);
	}

	// do not implement this functions?¿
	@Override
	public boolean isSolid(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}
}