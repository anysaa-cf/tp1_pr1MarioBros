package tp1.logic.gameobjects;

import tp1.logic.GameObject;
import tp1.logic.GameWorld;

public class NoParamsObject extends AbstractObject{

	public NoParamsObject(String name, String shortcut) {
		super(name, shortcut);
	}

	@Override
	public GameObject parse(String[] objWords, GameWorld game) {
		
		if(objWords.length == 3 && matchObjectName(objWords[2])) {
			return this;
		}
		return null;
	}

}
