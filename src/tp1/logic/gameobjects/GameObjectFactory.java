package tp1.logic.gameobjects;

import java.util.Arrays;
import java.util.List;

import tp1.logic.GameObject;
import tp1.logic.GameWorld;

public class GameObjectFactory {

	private static final List<GameObject> availableObjects = Arrays.asList( // these are all the possible actions that are going to be parsed by parse method in here
			new Ground(null, null),		// they have arguments in their constructors
			new ExitDoor(null, null),
			new Goomba(null, null),
			new Mario(null, null)
	);
	
	public GameObject parse (String objWords[], GameWorld game) {
		for(GameObject obj : availableObjects) {
			GameObject gameObject = obj.parse(objWords, game);		// calls the parse method of each gameObject
			
			if(gameObject != null) {
				return obj;
			}
		}

		return null;	
	}
}



