import java.awt.Color;

/**
 * symmetrical S shape tetris piece
 * 
 * @author Serena Wang
 * @version 1
 */
public class TetrisS2 extends TetrisPiece{
	/**
	 * Construct a tetris piece which is symmetrical to S shape
	 */
	public TetrisS2 (){
		super();
		
			filledSquares[0][0][0] = true;
			filledSquares[0][0][1] = true;
			filledSquares[0][1][2] = true;
			filledSquares[0][1][1] = true;
		
			filledSquares[1][0][1] = true;
			filledSquares[1][2][0] = true;
			filledSquares[1][1][0] = true;
			filledSquares[1][1][1] = true;
			
			filledSquares[2][0][0] = true;
			filledSquares[2][0][1] = true;
			filledSquares[2][1][2] = true;
			filledSquares[2][1][1] = true;
			
			filledSquares[3][0][1] = true;
			filledSquares[3][2][0] = true;
			filledSquares[3][1][0] = true;
			filledSquares[3][1][1] = true;
			
			pieceColor = Color.DARK_GRAY;
	}

}
