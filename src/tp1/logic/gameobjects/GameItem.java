package tp1.logic.gameobjects;

import tp1.logic.Position;

public interface GameItem {
	// funciones a lo solido e interacciones?¿
	public void update();
	public boolean isInPosition(Position p);
	public String getIcon();
}
