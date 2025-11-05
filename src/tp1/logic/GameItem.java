package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Goomba;
import tp1.logic.gameobjects.Ground;
import tp1.logic.gameobjects.Mario;

public interface GameItem {
	
		public boolean isSolid();
		public boolean isAlive();
		public boolean isInPosition(Position pos);

		public boolean interactWith(GameItem other);
		public boolean receiveInteraction(Ground ground);
		public boolean receiveInteraction(Mario mario);
		public boolean receiveInteraction(ExitDoor door);
		public boolean receiveInteraction(Goomba goomba);
}
