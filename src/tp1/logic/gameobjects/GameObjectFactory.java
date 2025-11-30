package tp1.logic.gameobjects;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.GameModelParseException;
import tp1.exceptions.ObjectParseException;
import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.view.Messages;

public class GameObjectFactory {

	private static final List<GameObject> availableObjects = Arrays.asList( // these are all the possible actions that are going to be parsed by parse method in here
			new Ground(null, null),		// they have arguments in their constructors
			new ExitDoor(null, null),
			new Goomba(null, null),
			new Mario(null, null),
			new Mushroom(null, null),
			new Box(null, null)
	);
	
	public static GameObject parse (String objWords[], GameWorld game) throws GameModelParseException {
		GameObject gameObject;
		
		for(GameObject obj : availableObjects) {
			try {
				gameObject = obj.parse(objWords, game);		// calls the parse method of each gameObject
				
				if(gameObject != null) {
					return gameObject;
				}
			} catch (ObjectParseException e) {
				throw e;
			}
			
		}

		throw new GameModelParseException(Messages.INVALID_GAME_OBJECT);	
	}
}



