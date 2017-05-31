import java.awt.Color;

/**
 * stick shape tetris piece
 * 
 * @author Serena Wang
 * @version 1
 */
public class TetrisStick extends TetrisPiece{
	/**
	 * Construct a stick shape tetris piece
	 */
	public TetrisStick(){
		super();
		
			filledSquares[0][0][0] = true;
			filledSquares[0][1][0] = true;
			filledSquares[0][2][0] = true;
			filledSquares[0][3][0] = true;
			
			filledSquares[1][0][0] = true;
			filledSquares[1][0][1] = true;
			filledSquares[1][0][2] = true;
			filledSquares[1][0][3] = true;
		
			filledSquares[2][1][0] = true;
			filledSquares[2][0][0] = true;
			filledSquares[2][2][0] = true;
			filledSquares[2][3][0] = true;
			
			filledSquares[3][0][0] = true;
			filledSquares[3][0][1] = true;
			filledSquares[3][0][2] = true;
			filledSquares[3][0][3] = true;
		
			pieceColor = Color.GREEN;
	} 

}
