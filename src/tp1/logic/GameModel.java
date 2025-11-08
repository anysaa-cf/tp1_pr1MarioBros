package tp1.logic;

public interface GameModel {
	// represent the Controller's view
	public boolean isFinished();
	public void update();
	public void reset();
	public void exit();
	public void marioExited();
	public boolean isSolid(Position pos);
	public void addPoints(int newPoints);
}
