import java.awt.Color;

/**
 * S shape tetris piece
 * 
 * @author Serena Wang
 * @version 1
 */
public class TetrisS extends TetrisPiece {
	/**
	 * Construct an S shape tetris piece
	 */
	public TetrisS() {
		super();
		
			filledSquares[0][0][1] = true;
			filledSquares[0][0][2] = true;
			filledSquares[0][1][0] = true;
			filledSquares[0][1][1] = true;
			
			filledSquares[1][0][1] = true;
			filledSquares[1][1][2] = true;
			filledSquares[1][2][2] = true;
			filledSquares[1][1][1] = true;
		
			filledSquares[2][0][1] = true;
			filledSquares[2][0][2] = true;
			filledSquares[2][1][0] = true;
			filledSquares[2][1][1] = true;
			
			filledSquares[3][0][1] = true;
			filledSquares[3][1][2] = true;
			filledSquares[3][2][2] = true;
			filledSquares[3][1][1] = true;
			
			pieceColor = Color.BLUE;

	}
}
