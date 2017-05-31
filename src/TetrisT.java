import java.awt.Color;

/**
 * T shape tetris piece
 * 
 * @author Serena Wang
 * @version 1
 */
public class TetrisT extends TetrisPiece{
	/**
	 * Construct a T shape tetris piece
	 */
	public TetrisT (){
		super();
		
			filledSquares[0][0][1] = true;
			filledSquares[0][1][0] = true;
			filledSquares[0][1][1] = true;
			filledSquares[0][1][2] = true;
		
			filledSquares[1][0][0] = true;
			filledSquares[1][1][0] = true;
			filledSquares[1][2][0] = true;
			filledSquares[1][1][1] = true;
	
			filledSquares[2][0][0] = true;
			filledSquares[2][0][1] = true;
			filledSquares[2][0][2] = true;
			filledSquares[2][1][1] = true;
		
			filledSquares[3][0][2] = true;
			filledSquares[3][1][1] = true;
			filledSquares[3][1][2] = true;
			filledSquares[3][2][2] = true;
			
			pieceColor = Color.MAGENTA;
		
	}

}
