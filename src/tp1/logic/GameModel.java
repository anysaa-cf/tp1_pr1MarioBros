package tp1.logic;

public interface GameModel {
	// represent the Controller's view
	public boolean isFinished();
	public void update();
	public void resetGame(int level);
	public void exit();
	
	public void marioExited();	//?¿
}
