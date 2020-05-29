package mechafinch.dumb.bot;

import java.io.File;
import java.io.IOException;

/**
 * stupid idiot chess bot doesn't even know how to play chess
 * 
 * @author Mechafinch
 */
public class ChessBot {
	
	public static void main(String[] args) throws IOException {
		// test time yaaaaaaaaaaay
		ChessGame test = new ChessGame();
		
		test.writeState(new File("board states/test1.txt"));
		test.readState(new File("board states/oh look a test.txt"));
		test.writeState(new File("board states/test2.txt"));
		test.readState(new File("board states/oh boy its another one.txt"));
		test.writeState(new File("board states/test3.txt"));
	}
}
