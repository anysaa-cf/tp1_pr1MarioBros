package tp1.logic;

/**
 * 
 * TODO: Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private final int col;
	private final int row;
	
	public Position(int row, int col) {		// int col, int row or viceversa?¿
		this.row = row;
		this.col = col;
	}
	 
	public int getRow() {
		return row;
	}


	public int getCol() {
		return col;
	}

	/*
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public boolean equals(Position position) {
		return this.col == position.col && this.row == position.row;
	}*/

}
