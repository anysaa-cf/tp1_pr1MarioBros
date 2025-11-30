package tp1.logic;

public interface GameModel {
	// represent the Controller's view
	public boolean isFinished();
	public void update();
	public void reset();
	public void exit();
	public void marioExited();
	public void addPoints(int newPoints);
	public void addObj(GameObject obj);
	public void addAction(Action action);
	public void setLevel(int level);
	public void initGame();
}
