package tp1.logic;

import tp1.exceptions.GameLoadException;

public interface GameRunStatus {
	public int remainingTime() throws GameLoadException;
	public int points() throws GameLoadException;
	public int numLives() throws GameLoadException;
}
