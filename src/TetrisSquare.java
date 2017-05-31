import java.awt.Color;

/**
 * square shape tetris piece
 * 
 * @author Serena Wang
 * @version 1
 */
public class TetrisSquare extends TetrisPiece{
	/**
	 * Construct a square shape tetris piece
	 */
	public TetrisSquare(){
		super();
		filledSquares[0][0][0] = true;
		filledSquares[0][0][1] = true;
		filledSquares[0][1][0] = true;
		filledSquares[0][1][1] = true;
		
		filledSquares[1][0][0] = true;
		filledSquares[1][0][1] = true;
		filledSquares[1][1][0] = true;
		filledSquares[1][1][1] = true;
		
		filledSquares[2][0][0] = true;
		filledSquares[2][0][1] = true;
		filledSquares[2][1][0] = true;
		filledSquares[2][1][1] = true;
		
		filledSquares[3][0][0] = true;
		filledSquares[3][0][1] = true;
		filledSquares[3][1][0] = true;
		filledSquares[3][1][1] = true;
		
		pieceColor = Color.cyan;
	}
}
