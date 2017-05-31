import java.awt.Color;

/**
 * symmetrical L shape tetris piece
 * 
 * @author Serena Wang
 * @version 1
 */
public class TetrisL2 extends TetrisPiece {
	/**
	 * Construct a tetris piece which is symmetrical to L shape
	 */
	public TetrisL2() {
		super();

		filledSquares[0][0][1] = true;
		filledSquares[0][1][1] = true;
		filledSquares[0][2][1] = true;
		filledSquares[0][2][0] = true;

		filledSquares[1][0][0] = true;
		filledSquares[1][1][0] = true;
		filledSquares[1][1][1] = true;
		filledSquares[1][1][2] = true;

		filledSquares[2][0][0] = true;
		filledSquares[2][0][1] = true;
		filledSquares[2][2][0] = true;
		filledSquares[2][1][0] = true;

		filledSquares[3][0][0] = true;
		filledSquares[3][0][1] = true;
		filledSquares[3][0][2] = true;
		filledSquares[3][1][2] = true;
		
		pieceColor = Color.YELLOW;
	}
}
