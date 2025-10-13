package tp1.logic;

/**
 * Represents the allowed actions in the game
 *
 */
public enum Action {
	LEFT(0,-1), RIGHT(0,1), DOWN(1,0), UP(-1, 0), STOP(0,0);

	private int x;
	private int y;
	
	private Action(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	//TODO fill your code
	
}
