package tp1.logic.gameobjects;

import tp1.logic.ActionList;
import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
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
		move();
	}
	
	public void marioDies() {
		if(life <= 0) {
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
		
			if(actionList.isEmpty()) {		// no more actions -> automatic movement
				nextPos = new Position(getRow() + action.getX(), getCol() + action.getY());
				 ground = GameObjectContainer.isSolid(nextPos); 																						
				
				if(!ground && game.isInsideBounds(nextPos))
					updatePos(nextPos); // automatic movement if there is no ground taken the last Action movement
			}
			else {		// actions -> movement declared by the player
				Action action = this.actionList.getAction();
				nextPos = new Position(getRow() + action.getX(), getCol() + action.getY());
				 ground = GameObjectContainer.isSolid(nextPos); 																						
			
				if(!ground && game.isInsideBounds(nextPos))
					processAction(action, nextPos);
				this.action = action;
			}
			if(actionList.isEmpty())
				restartC();
	}
	
	public void processAction(Action action, Position nextPos) {
		switch(action) {
		
		case Action.RIGHT:
			updatePos(nextPos);
			break;
		
		case Action.LEFT:
			updatePos(nextPos);
			break;

		case Action.UP:
			updatePos(nextPos);
			break;

		case Action.DOWN:
			updatePos(nextPos);	
			break;
		
		default:
			break;
		}
	}

}