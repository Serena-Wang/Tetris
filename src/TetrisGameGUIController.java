/**
 * GUI view controller for Tetris
 * 
 * @author Serena Wang
 * @version 1
 */
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class TetrisGameGUIController extends JPanel implements KeyListener,
		ActionListener {
	private static final int DEFAULT_DROP = 1000;
	private TetrisGame game;
	private TetrisBoardGUIView view;
	private JLabel linesLabel;
	private JLabel tetrisLabel;
	private JButton restart;
	private Timer gameTimer;
	private int lineCounter = 0;
	private int tetrisCounter = 0;

	/**
	 * Construct a new Tetris GUI controller
	 **/
	public TetrisGameGUIController() {
		super(new BorderLayout());
		addKeyListener(this);
		view = createView();
		this.add(view, BorderLayout.CENTER);
		setupTimer();
	}

	// Setup the timer for the game
	private void setupTimer() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// move down
				game.attemptMove(2);
				view.repaint();
			}
		};
		// drop by 1 second 
		gameTimer = new Timer(DEFAULT_DROP, taskPerformer);
		gameTimer.setRepeats(true);
		gameTimer.restart();
	}

	// create the set up for the JPanel and GUI view, and return the view
	private TetrisBoardGUIView createView() {
		// set up the board and the score counter
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(3, 1));
		setFocusable(true);
		game = new TetrisGame();
		restart = new JButton("restart");
		linesLabel = new JLabel("Lines cleared " + lineCounter);
		tetrisLabel = new JLabel("Tetrises cleared " + tetrisCounter);
		labelPanel.add(restart);
		labelPanel.add(linesLabel);
		labelPanel.add(tetrisLabel);
		restart.addActionListener(this);
		this.add(labelPanel, BorderLayout.NORTH);
		// create the view
		view = new TetrisBoardGUIView(game.getTetrisBoard());
		return view;
	}

	// update the score and refresh the display
	private void createScore() {
		lineCounter = game.getTetrisBoard().getLineScore();
		tetrisCounter = game.getTetrisBoard().getNumTetrisFormed();
		linesLabel.setText("Lines cleared " + lineCounter);
		tetrisLabel.setText("Tetrises cleared " + tetrisCounter);
		view.repaint();
	}

	/**
	 * Handle the key pressed event
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_DOWN) {
			game.attemptMove(2);
		} else if (key == KeyEvent.VK_LEFT) {
			game.attemptMove(3);
		} else if (key == KeyEvent.VK_RIGHT) {
			game.attemptMove(4);
		} else if (key == KeyEvent.VK_Z) {
			game.attemptMove(0);
		} else if (key == KeyEvent.VK_X) {
			game.attemptMove(1);
		}
		// refresh the display and update the score
		view.repaint();
		createScore();
	}

	/**
	 * Handle the key released event
	 */
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Handle the key typed event
	 */
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * restart the game
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == restart) {
			this.removeAll();
			this.revalidate();
			this.repaint();
			view = createView();
			createScore();
			view.repaint();
			this.add(view, BorderLayout.CENTER);
		}
	}
}
