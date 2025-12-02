package tp1.logic;

import java.util.List;

import tp1.exceptions.GameLoadException;
import tp1.logic.gameobjects.Mario;

public interface GameConfiguration extends GameRunStatus {
	
	public Mario getMario() throws GameLoadException;
	public List<GameObject> getNPCObjects();
	
}
