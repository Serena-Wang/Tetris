/**
 * Model for Tetris
 * 
 * @author Serena Wang
 * @version 1
 */
public class TetrisGame {
	private TetrisBoard tetrisBoard;
	private static final int CCW = 0;
	private static final int CW = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static final int RIGHT = 4;

	/**
	 * Construct a new Tetris game
	 **/
	public TetrisGame() {
		tetrisBoard = new TetrisBoard();
	}

	/**
	 * Get the board
	 * 
	 * @return board
	 */
	public TetrisBoard getTetrisBoard() {
		return tetrisBoard;
	}
	
	/**
	 * Give instruction to the controller
	 * 
	 * @param moveType
	 *            the type of moves
	 */
	public void attemptMove(int moveType) {
		if (moveType == RIGHT) {
			tetrisBoard.moveRight();
		} else if (moveType == LEFT) {
			tetrisBoard.moveLeft();
		} else if (moveType == CW) {
			tetrisBoard.rotateCW();
		} else if (moveType == CCW) {
			tetrisBoard.rotateCCW();
		} else if (moveType == DOWN) {
			tetrisBoard.moveDownOrDrop();
		}
	}

}
