package tp1.logic;

/**
 * 
 * TODO: Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private final int col;
	private final int row;
	
	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}
	 
	public int getRow() {
		return row;
	}


	public int getCol() {
		return col;
	}

	public boolean equals(Position position) {
		return this.col == position.col && this.row == position.row;
	}

}
