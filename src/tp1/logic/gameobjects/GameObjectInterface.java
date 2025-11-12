package tp1.logic.gameobjects;

import tp1.logic.GameObject;
import tp1.logic.GameWorld;

public interface GameObjectInterface {
	public GameObject parse (String objWords[], GameWorld game);
}
