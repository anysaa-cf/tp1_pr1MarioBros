package tp1.logic.gameobjects;

import tp1.logic.GameItem;

public abstract class AbstractObject implements GameObjectInterface {
	private final String name;
	private final String shortcut;
	
	public AbstractObject(String name, String shortcut) {
		this.name = name;
		this.shortcut = shortcut;
	}
	
	protected String getName() { return name; }
	protected String getShortcut() { return shortcut; }
	
	protected boolean matchObjectName(String nameObject) {
		return getShortcut().equalsIgnoreCase(nameObject) ||
				getName().equalsIgnoreCase(nameObject);
	}
	
	
	
}
