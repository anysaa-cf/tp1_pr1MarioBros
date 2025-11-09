package tp1.logic.gameobjects;

import java.util.Arrays;
import java.util.List;

import tp1.logic.GameObject;
import tp1.logic.GameWorld;
import tp1.logic.Position;

public class GameObjectFactory {

	private static final List<GameObject> availableObjects = Arrays.asList( // these are all the possible actions that are going to be parsed by parse method in here
			new Ground(null, null),		// they have arguments in their constructors
			new ExitDoor(null, null),
			new Goomba(null, null),
			new Mario(null, null)
	);
	
	
	
	
	public static GameObject parse (String objWords[], GameWorld game) {
		if(objWords.length >= 3 && objWords.length <= 5) {		
			// each coordinate row and col counts as an element in the array
			int row, col;
			
			row = Integer.parseInt(objWords[0]);
			col = Integer.parseInt(objWords[1]);
			
			Position position = new Position(row, col);
			
			String objType = objWords[2].toLowerCase();
			
			for(GameObject obj : availableObjects) {
				// i have no idea, i was going to do a getter xd
				if(obj != null) {
					return obj;
				}
			}
			
			// there are attributes 
			if(objWords[3] != null) {
				// check the type of action that performs
			}
			
			if(objWords[4] != null) {
				// check if the attribute of big for mario is written for the new gameObject
			}
			
		}
		
		
		return null;
		
	}
}



