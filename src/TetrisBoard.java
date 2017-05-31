/**
 * Model for Tetris
 * 
 * @author Serena Wang
 * @version 2
 */
import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.awt.*;

public class TetrisBoard {
	/**
	 * Value for the total number of the rows in a board
	 */
	public static final int BOARD_ROW = 18;
	/**
	 * Value for the total number of the columns in a board
	 */
	public static final int BOARD_COL = 10;
	private int lineCounter = 0;
	private int numTetrisFormed = 0;
	private int score = 0;
	private int[] currentPieceGridPosition = new int[2];
	private boolean[][] board, boardCopy;
	private TetrisPiece currentPiece;
	private File tetrisCleared;

	/**
	 * Construct a new Tetris Board
	 **/
	public TetrisBoard() {
		initBoard();
		addNewPiece();
		tetrisCleared = new File("resources/sound1.WAV");
	}

	/**
	 * Initialize the board board is for recording the positions of landed
	 * pieces boardCopy is a copy of board
	 */
	public void initBoard() {
		board = new boolean[BOARD_ROW][BOARD_COL];
		boardCopy = new boolean[BOARD_ROW][BOARD_COL];
	}

	/**
	 * Get the board copy
	 * 
	 * @return boardCopy
	 */
	public boolean[][] getBoardCopy() {
		return boardCopy;
	}

	// Initialize the current piece grid position
	private void initGP() {
		// row
		currentPieceGridPosition[0] = 0;
		// column
		currentPieceGridPosition[1] = 3;
	}

	/**
	 * Add a new Tetris piece to the board randomly
	 */
	public void addNewPiece() {
		// randomly choose a piece
		int randPiece = (int) (Math.random() * 7);
		if (randPiece == 0) {
			currentPiece = new TetrisL();
		} else if (randPiece == 1) {
			currentPiece = new TetrisL2();
		} else if (randPiece == 2) {
			currentPiece = new TetrisS();
		} else if (randPiece == 3) {
			currentPiece = new TetrisS2();
		} else if (randPiece == 4) {
			currentPiece = new TetrisSquare();
		} else if (randPiece == 5) {
			currentPiece = new TetrisStick();
		} else {
			currentPiece = new TetrisT();
		}
		// initialize the position of this piece
		initGP();

	}

	/**
	 * Move the current piece left
	 */
	public void moveLeft() {
		if (validMove(currentPiece, currentPiece.getPieceRotation(),
				currentPieceGridPosition[0], currentPieceGridPosition[1] - 1) == true) {
			currentPieceGridPosition[1] = currentPieceGridPosition[1] - 1;

		}
	}

	/**
	 * Move the current piece right
	 */
	public void moveRight() {
		if (validMove(currentPiece, currentPiece.getPieceRotation(),
				currentPieceGridPosition[0], currentPieceGridPosition[1] + 1) == true) {
			currentPieceGridPosition[1] = currentPieceGridPosition[1] + 1;
		}
	}

	/**
	 * Move the current piece down or land a piece
	 */
	public void moveDownOrDrop() {
		// move it down
		if (validMove(currentPiece, currentPiece.getPieceRotation(),
				currentPieceGridPosition[0] + 1, currentPieceGridPosition[1]) == true) {
			currentPieceGridPosition[0] = currentPieceGridPosition[0] + 1;
		} else {
			// land a piece
			for (int row = 0; row < 4; row++) {
				for (int col = 0; col < 4; col++) {
					if (currentPiece.isFilled(currentPiece.getPieceRotation(),
							row, col) == true) {
						board[getNumRows() + row][getNumCols() + col] = true;
					   
					}
				}
			}
			// check full lines and lost status
			checkFullLines();
			playSound(tetrisCleared);
			if (checkLost()) {
				System.out.print("You Lost!");
				System.exit(0);
			} else {
				addNewPiece();
			}
		}
	}

	// Check whether the user loses the game
	private boolean checkLost() {
		// if there is no place for adding a new piece
		if (board[0][3] == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Rotate the piece clock wise
	 */
	public void rotateCW() {
		if (validMove(currentPiece, (currentPiece.getPieceRotation() + 1) % 4,
				currentPieceGridPosition[0], currentPieceGridPosition[1]) == true) {
			currentPiece.rotateCW();
		}
	}

	/**
	 * Rotate the piece counter clock wise
	 */
	public void rotateCCW() {
		int newRot = 0;
		if (currentPiece.getPieceRotation() - 1 == -1) {
			newRot = 3;
		} else {
			newRot = currentPiece.getPieceRotation() - 1;
		}
		if (validMove(currentPiece, newRot, currentPieceGridPosition[0],
				currentPieceGridPosition[1]) == true) {
			currentPiece.rotateCCW();
		}
	}

	// Checks if placing the piece at grid position (row, col) with the rotation
	// rot (values can be 0, 90, 180, 270) would cause a collision.
	private boolean detectCollison(TetrisPiece piece, int rot, int gridRow,
			int gridCol) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (piece.isFilled(rot, i, j) == true
						&& board[gridRow + i][gridCol + j] == true) {
					return true;
				}
			}
		}
		return false;
	}

	// Checks if placing the piece at grid position (row, col) with the rotation
	// rot (values can be 0, 90, 180, 270) would cause an out of bounds
	// condition.
	private boolean detectOutOfBound(TetrisPiece piece, int rot, int gridRow,
			int gridCol) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (piece.isFilled(rot, i, j) == true
						&& (gridRow + i < 0 || gridRow + i >= BOARD_ROW
								|| gridCol + j >= BOARD_COL || gridCol + j < 0)) {
					return true;
				}
			}
		}
		return false;
	}

	// Checks if placing the piece at grid position (row, col) with the rotation
	// rot (values can be 0, 90, 180, 270) is a valid move.
	private boolean validMove(TetrisPiece piece, int rot, int gridRow,
			int gridCol) {
		if (detectOutOfBound(piece, rot, gridRow, gridCol) == false) {
			if (detectCollison(piece, rot, gridRow, gridCol) == false) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// check whether the assigned row is full
	private boolean fullLine(int row) {
		for (int col = 0; col < BOARD_COL; col++) {
			if (board[row][col] == false) {
				return false;
			}
		}
		removeLine(row);
		return true;
	}

	// remove the full row
	private void removeLine(int row) {
		for (int col = 0; col < BOARD_COL; col++) {
			board[row][col] = false;
		}
		// drag everything down
		for (int r = row; r > 0; r--) {
			for (int col = 0; col < BOARD_COL; col++) {
				board[r][col] = board[r - 1][col];
			}
		}
	}

	// check full lines, remove them and update the scores
	private void checkFullLines() {
		for (int row = 0; row < BOARD_ROW; row++) {
			if (fullLine(row)) {
				lineCounter++;
			}
		}
		if (lineCounter == 4) {
			lineCounter = 0;
			numTetrisFormed++;
		} else {
			score += lineCounter;
			lineCounter = 0;
		}
	}
	
	// play the wav file in the folder
	// This code is from the Internet and the link is in the readme file
	private static void playSound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);
		} catch (Exception e) {

		}
	}

	/**
	 * 
	 * @return the block matrix (the grid of blocks)
	 */
	public boolean[][] getBlockMatrix() {
		return board;
	}

	/**
	 * 
	 * @return the currentPiece
	 */
	public TetrisPiece getCurrentPiece() {
		return currentPiece;
	}
    /**
     * 
     * @return the color of the currentPiece
     */
	public Color getCurrentPieceColor() {
		return currentPiece.getColor();
	}

	/**
	 * 
	 * @return column of the currentPiece position
	 */
	public int getNumCols() {
		return currentPieceGridPosition[1];
	}

	/**
	 * 
	 * @return row of the currentPiece position
	 */
	public int getNumRows() {
		return currentPieceGridPosition[0];
	}

	/**
	 * 
	 * @return number of lines which have been removed
	 */
	public int getLineScore() {
		return score;
	}

	/**
	 * 
	 * @return number of tetris formed
	 */
	public int getNumTetrisFormed() {
		return numTetrisFormed;
	}

	/**
	 * 
	 * @return row size of the board
	 */
	public int getTotalRows() {
		return BOARD_ROW;
	}

	/**
	 * 
	 * @return column size of the board
	 */
	public int getTotalCols() {
		return BOARD_COL;
	}
}
