package tp1.logic.gameobjects;

import tp1.logic.ActionList;
import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.GameItem;
import tp1.logic.Position;
import tp1.view.Messages;

public class Mario extends MovingObject {

	private ActionList actionList;
	private int life; // added recently, now that there is a Mario object in game, we can have life attribute here 
	private int rightC, leftC, upC, downC;
	private boolean big;		
	
	public Mario(Game game, Position pos) {
		super(game, pos, Action.RIGHT);
		this.actionList = new ActionList();
		this.big = true;
		this.life = 3;
		this.rightC = this.leftC = this.upC = this.downC = 0;
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

	public void update() {
		while(!actionList.isEmpty()) {
			move();
			game.tryInteractionsFrom(this);
		}
	}
	
	public void marioDies() {
		if(life <= 0) {
			objectDies();
			game.marioDies();
			objectDies();
		}
		else {
			if(big)
				this.big = false;
			else
				this.life--;
		}
			
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
		 		if(leftC == 0 && rightC < ActionList.maxActions) {
		 			ok = true;
		 			rightC++;
		 		}
		 		break;
		 	
		 	case LEFT:
		 		if(rightC == 0 && leftC < ActionList.maxActions) {
		 			ok = true;
		 			leftC++;
		 		}
				 break;
			
		 	case UP:
		 		if(downC == 0 && upC < ActionList.maxActions) {
		 			ok = true;
		 			upC++;
		 		}
				 break;
				 
		 	case DOWN:
		 		if(upC == 0 && downC < ActionList.maxActions) {
		 			ok = true;
		 			downC++;
		 		}
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
	
	public void addPoints(int newPoints) {
		game.addPoints(newPoints);
	}

	protected void move() {
		Position nextPos;
		boolean ground;
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
			if(actionList.isEmpty())
				restartC();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveInteraction(ExitDoor door) {
		
		return true;
	}

	@Override
	public boolean receiveInteraction(Goomba goomba) {
		if(!isFalling()) {
			marioDies();
			Position returnPos = new Position(getRow() - action.getX(), getCol() - action.getY()); 
			updatePos(returnPos);
		}
		else
			game.addPoints(10);
			
		return false;
	}

}