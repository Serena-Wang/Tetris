/**
 * GUI view application for Tetris
 * Bonus : 1. restart the game.  
 *         2. add sound when a tetris is cleared. 
 *         3. add color to different Tetris pieces.
 * 
 * @author Serena Wang
 * @version 1
 */

import javax.swing.*;

public class TetrisGUIApplication {
	/**
	 * Start the view version game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new TetrisGUIApplication();
	}

	/**
	 * Create the set up of the game
	 * 
	 * @param args
	 */
	public TetrisGUIApplication() {
		JFrame gameFrame = new JFrame("Tetris");
		gameFrame.add(new TetrisGameGUIController());
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(400, 500);
		gameFrame.setVisible(true);
	}
}
