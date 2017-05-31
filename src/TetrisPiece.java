/**
 * The TetrisPiece abstract class represents a piece made of 4 TetrisBlocks. It
 * maintains 4 rotations (0 degrees, 90 degrees, 180 degrees and 270 degrees),
 * with each being a 4x4 grid with certain filled squares.
 * 
 * @author Serena Wang
 * @version 1
 */
import java.awt.*;
public abstract class TetrisPiece {
	// an array for recording the pieces
	protected boolean[][][] filledSquares;
	private int pieceRotation;
	protected Color pieceColor;

	/**
	 * Construct a Tetris piece and initialize the array and rotation
	 */
	public TetrisPiece() {
		filledSquares = new boolean[4][4][4];
		pieceColor = null;
		pieceRotation = 0;
	}

	/**
	 * Update the rotation for clock wise movement
	 */
	public void rotateCW() {
		pieceRotation++;
		if (pieceRotation == 4) {
			pieceRotation = 0;
		}
	}

	/**
	 * Update the rotation for counter clock wise movement
	 */
	public void rotateCCW() {
		pieceRotation--;
		if (pieceRotation == -1) {
			pieceRotation = 3;
		}
	}

	/**
	 * Get the current rotation status
	 */
	public int getPieceRotation() {
		return pieceRotation;
	}

	/**
	 * Check which cell in the array is filled in different rotation
	 */
	public boolean isFilled(int rot, int row, int col) {
		if (filledSquares[rot][row][col] == true) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Get the color of the piece 
	 * @return the color
	 */
	public Color getColor(){
		return pieceColor;
	}
}
