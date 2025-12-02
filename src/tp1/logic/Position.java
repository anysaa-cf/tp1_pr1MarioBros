package tp1.logic;

import tp1.exceptions.PositionParseException;

/**
 * 
 * TODO: Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private final int col;
	private final int row;
	
	public Position(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public static Position parsePosition(String position) throws PositionParseException{
		int row, col;
		String aux = position.replaceAll("[()\\s]", ""); // deletes '(', ')' and spaces
        String[] part = aux.split(",");
        row = Integer.parseInt(part[0]);
        col = Integer.parseInt(part[1]);
        return new Position(row, col);
        
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
