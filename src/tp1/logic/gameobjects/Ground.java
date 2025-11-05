package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameItem;
import tp1.logic.GameObject;
import tp1.logic.Position;
import tp1.view.Messages;

public class Ground extends GameObject {

	public Ground(Game game, Position pos) {
		super(game, pos, true);
	}
	
	public String getIcon() {
		return Messages.LAND;
	}
	
	public void update() {
	
	}

	public boolean isAlive() {
		return false;
	}

	@Override
	public boolean interactWith(GameItem other) {
		return false;
	}

	@Override
	public boolean receiveInteraction(Ground ground) {
		return false;
	}

	@Override
	public boolean receiveInteraction(Mario mario) {
		return false;
	}

	@Override
	public boolean receiveInteraction(ExitDoor door) {
		return false;
	}

	@Override
	public boolean receiveInteraction(Goomba goomba) {
		return false;
	}


}
