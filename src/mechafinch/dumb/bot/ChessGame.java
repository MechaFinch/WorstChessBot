package mechafinch.dumb.bot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * An instance of a chess game
 * 
 * @author Mechafinch
 */
public class ChessGame {
	
	private static final ChessPiece[][] initialBoard = new ChessPiece[][] {
		{ChessPiece.fromString("br"), ChessPiece.fromString("bn"), ChessPiece.fromString("bb"), ChessPiece.fromString("bq"), ChessPiece.fromString("bk"), ChessPiece.fromString("bb"), ChessPiece.fromString("bn"), ChessPiece.fromString("br")},
		{ChessPiece.fromString("bp"), ChessPiece.fromString("bp"), ChessPiece.fromString("bp"), ChessPiece.fromString("bp"), ChessPiece.fromString("bp"), ChessPiece.fromString("bp"), ChessPiece.fromString("bp"), ChessPiece.fromString("bp")},
		{null, null, null, null, null, null, null, null},
		{null, null, null, null, null, null, null, null},
		{null, null, null, null, null, null, null, null},
		{null, null, null, null, null, null, null, null},
		{ChessPiece.fromString("wp"), ChessPiece.fromString("wp"), ChessPiece.fromString("wp"), ChessPiece.fromString("wp"), ChessPiece.fromString("wp"), ChessPiece.fromString("wp"), ChessPiece.fromString("wp"), ChessPiece.fromString("wp")},
		{ChessPiece.fromString("wr"), ChessPiece.fromString("wn"), ChessPiece.fromString("wb"), ChessPiece.fromString("wq"), ChessPiece.fromString("wk"), ChessPiece.fromString("wb"), ChessPiece.fromString("wn"), ChessPiece.fromString("wr")}
	};
	
	private ChessPiece[][] board;
	
	/**
	 * Starts a new chess game
	 */
	public ChessGame() {
		board = initialBoard;
	}
	
	/**
	 * Loads a board state from a csv file
	 * 
	 * @param f The file to read from
	 */
	public ChessGame(File f) throws IOException {
		readState(f);
	}
	
	/**
	 * Loads a board state from a file
	 * 
	 * @param f The file to read from
	 * @throws IOException
	 */
	public void readState(File f) throws IOException {
		ChessPiece[][] newBoard = new ChessPiece[8][8];
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = "";
		int ln = 0;
		
		// Read up to 8 lines of board
		while((line = br.readLine()) != null && ln < 8) {
			int i = 0;
			
			// Each CSV value
			for(String s : line.split(",")) {
				newBoard[ln][i] = ChessPiece.fromString(s);
				i++;
			}
			
			ln++;
		}
		
		br.close();
		
		// Not enough lines?
		if(ln != 8) throw new IllegalArgumentException("Missing lines");
		
		board = newBoard;
	}
	
	/**
	 * Writes the board state to a file
	 * 
	 * @param f The file to write to
	 * @throws IOException
	 */
	public void writeState(File f) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == null) {
					bw.write("no");
				} else {
					bw.write(board[i][j].toString());
				}
				
				if(j != board[i].length - 1) bw.write(",");
				else if(i != board.length - 1) bw.write("\n");
			}
		}
		
		bw.close();
	}
}
