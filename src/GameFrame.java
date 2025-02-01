import javax.swing.JFrame;

/**
 * This class contains the constructor to display the JFrame that the game runs on.
 */
public class GameFrame extends JFrame {
	
	/**
	 * Constructs a new GameFrame object that adds a new GamePanel object.
	 */
	GameFrame(){
		this.add(new GamePanel());	// Adds the game panel to the game frame.
		this.setTitle("Why Did the Chicken Cross the Road?");	// Sets the title of the frame.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Sets the default operation on close.
		this.setResizable(false);	// Set the frames size to be fixed (can not resize).
		this.pack();	// Makes the frame wrap around the contents of the frame.
		this.setVisible(true);	// Sets the frame to be visible.
		this.setLocationRelativeTo(null);	// Positions the frame in the middle of the screen on start.
	}
}
