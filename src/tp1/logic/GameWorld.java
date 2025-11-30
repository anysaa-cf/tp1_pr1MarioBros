package tp1.logic;

public interface GameWorld {
	// represent the Model's internal view 
	public void tryInteractionsFrom(GameItem object);
	public boolean isInsideBounds(Position nextPos);
	public boolean isDifferent(GameItem o1, GameItem o2);
	public void marioExited();
	public void marioDies();
	public void win();
	public void addPoints(int i);
	public void addObj(GameObject obj);
	public boolean isSolid(Position nextPos);
	public int getLevel();
}
