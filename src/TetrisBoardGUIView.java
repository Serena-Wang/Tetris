/**
 * GUI view for Tetris
 * 
 * @author Serena Wang
 * @version 1
 */
import java.awt.*;
import javax.swing.*;

public class TetrisBoardGUIView extends JComponent {
	private TetrisBoard board;
	private int boardWidth = 0;
	private int boardHeight = 0;

	/**
	 * Construct a GUI view for the game
	 * 
	 * @param b
	 *            TetrisBoard
	 */
	public TetrisBoardGUIView(TetrisBoard b) {
		setFocusable(true);
		board = b;
	}

	// Compute the block size for the current width and height and return the
	// size
	private int computeBlockSize() {
		int blockSize = 0;
		boardHeight = this.getHeight() * 9 / 10;
		boardWidth = (boardHeight / board.getTotalRows())
				* board.getTotalCols();
		blockSize = boardHeight / board.getTotalRows();
		return blockSize;
	}
    
	// Paint the outline of the game board
	private void paintBoardOutline(Graphics g) {
		g.drawLine(0, 0, boardWidth, 0);
		g.drawLine(0, 0, 0, boardHeight);
		g.drawLine(0, boardHeight, boardWidth, boardHeight);
		g.drawLine(boardWidth, 0, boardWidth, boardHeight);
	}
    
	// Paint the block of the assigned size at grid row, grid col 
	private void paintBlock(Graphics g, int row, int col, int blockSize) {
		int x = col * blockSize;
		int y = row * blockSize;
		g.setColor(board.getCurrentPieceColor());
		g.fillRect(x, y, blockSize, blockSize);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, blockSize, blockSize);
	}
	
	// copy the actual gameBoard to show the landed pieces
	private void copyBoard(boolean[][] gameBoard) {
		for (int row = 0; row < board.getTotalRows(); row++) {
			for (int col = 0; col < board.getTotalCols(); col++) {
				gameBoard[row][col] = board.getBlockMatrix()[row][col];
			}
		}
	}

	// record the current piece position on the boardcopy
	private void updatePiece(boolean[][] gameBoard) {
		TetrisPiece currentPiece = board.getCurrentPiece();
		copyBoard(gameBoard);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (currentPiece
						.isFilled(currentPiece.getPieceRotation(), i, j) == true) {
					gameBoard[(board.getNumRows() + i)][(board.getNumCols() + j)] = true;
				}
			}
		}
	}

	/**
	 * Paint the game
	 */
	public void paint(Graphics g) {
		boolean[][] gameBoard = board.getBoardCopy();
		int blockSize = computeBlockSize();
		updatePiece(gameBoard);
		paintBoardOutline(g);
		for (int row = 0; row < board.getTotalRows(); row++) {
			for (int col = 0; col < board.getTotalCols(); col++) {
				if (gameBoard[row][col] == true) {
					paintBlock(g, row, col, blockSize);
				}
			}
		}
	}
}
