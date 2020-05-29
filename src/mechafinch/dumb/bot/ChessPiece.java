package mechafinch.dumb.bot;

/**
 * a piece you can have on the board
 */
public class ChessPiece {
	
	private Pieces type;
	private boolean white;
	
	/**
	 * Creates a chess piece explicitly
	 * 
	 * @param type Enumerated piece type
	 * @param white True if white, false if black
	 */
	public ChessPiece(Pieces type, boolean white) {
		this.type = type;
		this.white = white;
	}
	
	/**
	 * Parses a 2 character string representation of a piece
	 * 
	 * @param s CSV 2 character representation
	 * @return The piece, or null if there shouldn't be a piece
	 */
	public static ChessPiece fromString(String s) {
		if(s.equals("no")) return null;
		
		boolean color = s.charAt(0) == 'w';
		
		if(!color && s.charAt(0) != 'b') throw new IllegalArgumentException("Malformed piece string: " + s);
		
		switch(s.charAt(1)) {
			case 'p':
				return new ChessPiece(Pieces.PAWN, color);
				
			case 'r':
				return new ChessPiece(Pieces.ROOK, color);
				
			case 'n':
				return new ChessPiece(Pieces.KNIGHT, color);
				
			case 'b':
				return new ChessPiece(Pieces.BISHOP, color);
				
			case 'q':
				return new ChessPiece(Pieces.QUEEN, color);
				
			case 'k':
				return new ChessPiece(Pieces.KING, color);
				
			default:
				throw new IllegalArgumentException("Malformed piece string: " + s);
		}
	}
	
	/**
	 * getty bois
	 */
	public Pieces getType() { return type; }
	public boolean isWhite() { return white; }
	
	@Override
	public String toString() {
		String s = white ? "w" : "b";
		
		switch(type) {
			case PAWN:
				return s + "p";
				
			case ROOK:
				return s + "r";
				
			case KNIGHT:
				return s + "n";
				
			case BISHOP:
				return s + "b";
				
			case QUEEN:
				return s + "q";
				
			case KING:
				return s + "k";
				
			default:
				throw new IllegalArgumentException("what: " + type + " " + white);
		}
	}
}

enum Pieces {
	PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING;
}





