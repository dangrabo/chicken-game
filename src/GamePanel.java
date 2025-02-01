import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 * This class contains all the methods that allow the game to function.
 */
public class GamePanel extends JPanel implements ActionListener {
	
	static final int SCREEN_WIDTH = 550;
	static final int SCREEN_HEIGHT = 400;
	static final int UNIT_SIZE = 50;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 200;
	final int vHeight = UNIT_SIZE - 10;
	
	final int roadOneX[] = new int[7];
	final int roadOneY = UNIT_SIZE + 5;
	int roadOneStart = 0;
	
	final int roadTwoX[] = new int[6];
	final int roadTwoY = UNIT_SIZE * 3 + 5;
	int roadTwoStart = UNIT_SIZE;
	
	final int roadThreeX[] = new int[4];
	final int roadThreeY = UNIT_SIZE * 5 + 5;
	
	int chickenX = UNIT_SIZE * 5;
	int chickenY = SCREEN_HEIGHT - UNIT_SIZE;
	
	char direction = 'N';
	boolean running = false;
	
	Timer timer;
	Random random;

	JButton endbutton = new JButton("Play Again");

	/**
	 * Constructs the game panel to display the game.
	 */
	public GamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(new Color(248, 240, 164));
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	
	/**
	 * Starts the game
	 */
	private void startGame() {
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	/**
	 * Paints the components of the game
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawSetting(g);
		draw(g);
	}
	
	/**
	 * Draws the player, cars, and ending screens.
	 * 
	 * @param g	Graphics object for drawing.
	 */
	public void draw(Graphics g) {
		if(running) {
			// Draw player
			g.setColor(Color.WHITE);
			g.fillOval(chickenX, chickenY, 20, 20);
			g.fillOval(chickenX + 10, chickenY + 10, 30, 30);
			g.setColor(Color.BLACK);
			g.fillOval(chickenX + 5, chickenY + 5, 5, 5);
			g.setColor(Color.yellow);
			Polygon beak = new Polygon();
			beak.addPoint(chickenX + 5, chickenY + 5);
			beak.addPoint(chickenX + 5, chickenY + 15);
			beak.addPoint(chickenX - 5, chickenY + 7);
			g.fillPolygon(beak);
			g.setColor(Color.BLACK);
			
			// Draw cars on first road
			g.setColor(Color.RED);
			g.fillRect(roadOneStart, roadOneY, UNIT_SIZE, vHeight);
			g.fillRect(roadOneStart + UNIT_SIZE * 3, roadOneY, UNIT_SIZE, vHeight);
			g.fillRect(roadOneStart + UNIT_SIZE * 6, roadOneY, UNIT_SIZE, vHeight);
			g.fillRect(roadOneStart + UNIT_SIZE * 9, roadOneY, UNIT_SIZE, vHeight);
			g.fillRect(roadOneStart + UNIT_SIZE * -3, roadOneY, UNIT_SIZE, vHeight);
			g.fillRect(roadOneStart + UNIT_SIZE * -6, roadOneY, UNIT_SIZE, vHeight);
			g.fillRect(roadOneStart + UNIT_SIZE * -9, roadOneY, UNIT_SIZE, vHeight);
			
			// Draw cars on second road
			g.setColor(Color.BLUE);
			g.fillRect(roadTwoStart, roadTwoY, UNIT_SIZE, vHeight);
			g.fillRect(roadTwoStart + UNIT_SIZE * 3, roadTwoY, UNIT_SIZE, vHeight);
			g.fillRect(roadTwoStart + UNIT_SIZE * 6, roadTwoY, UNIT_SIZE, vHeight);
			g.fillRect(roadTwoStart + UNIT_SIZE * 12, roadTwoY, UNIT_SIZE, vHeight);
			g.fillRect(roadTwoStart + UNIT_SIZE * 15, roadTwoY, UNIT_SIZE, vHeight);
			g.fillRect(roadTwoStart + UNIT_SIZE * 18, roadTwoY, UNIT_SIZE, vHeight);
			
			// Draw cars on third road
			g.setColor(Color.GREEN);
			g.fillRect(roadOneStart, roadThreeY, UNIT_SIZE, vHeight);
			g.fillRect(roadOneStart + UNIT_SIZE * 6, roadThreeY, UNIT_SIZE, vHeight);
			g.fillRect(roadOneStart + UNIT_SIZE * -3, roadThreeY, UNIT_SIZE, vHeight);
			g.fillRect(roadOneStart + UNIT_SIZE * -9, roadThreeY, UNIT_SIZE, vHeight);
		}
		else {
			if (chickenY == 0) {
				// Draw win screen
				Background.paintComponent(g,SCREEN_WIDTH, SCREEN_HEIGHT, UNIT_SIZE);
				g.setColor(Color.GREEN);
				g.setFont(new Font("Ink Free", Font.BOLD, 75));
				FontMetrics metrics = getFontMetrics(g.getFont());
				g.drawString("WINNER!", (SCREEN_WIDTH - metrics.stringWidth("WINNER!"))/2, SCREEN_HEIGHT/2);
				
				// Set button
				endbutton.setBounds(UNIT_SIZE * 4, UNIT_SIZE * 5, UNIT_SIZE * 3, UNIT_SIZE);
				endbutton.setBackground(Color.GREEN);
				endbutton.addActionListener(this);
				this.add(endbutton);
			}
			else {
				//Draw loss screen
				gameOver(g);
			}
		}	
	}
	
	/**
	 * Draws the map for the game.
	 * 
	 * @param g	Graphics object for drawing.
	 */
	public void drawSetting(Graphics g) {
		//Draws Grid
		// for(int i=0; i<SCREEN_WIDTH/UNIT_SIZE; i++)
		// 	g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
		// for(int i=0; i<SCREEN_HEIGHT/UNIT_SIZE; i++)
		// 	g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
		
		// Draw setting
		// Water
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, SCREEN_WIDTH, UNIT_SIZE);
		
		// Grass
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, SCREEN_WIDTH, UNIT_SIZE);
		g.fillRect(0, SCREEN_HEIGHT - UNIT_SIZE, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		// Roads
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, UNIT_SIZE * 5, SCREEN_WIDTH, UNIT_SIZE);
		g.fillRect(0, UNIT_SIZE * 3, SCREEN_WIDTH, UNIT_SIZE);
		g.fillRect(0, UNIT_SIZE, SCREEN_WIDTH, UNIT_SIZE);
		
		//Road lines
		for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i += 2) {
			g.setColor(Color.YELLOW);
			g.drawLine(i * UNIT_SIZE, UNIT_SIZE * 5 + (UNIT_SIZE / 2), i * UNIT_SIZE + UNIT_SIZE, UNIT_SIZE * 5 + (UNIT_SIZE / 2));
		}
		for (int i = 1; i < SCREEN_WIDTH / UNIT_SIZE; i += 2) {
			g.setColor(Color.YELLOW);
			g.drawLine(i * UNIT_SIZE, UNIT_SIZE * 3 + (UNIT_SIZE / 2), i * UNIT_SIZE + UNIT_SIZE, UNIT_SIZE * 3 + (UNIT_SIZE / 2));
		}
		for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i += 2) {
			g.setColor(Color.YELLOW);
			g.drawLine(i * UNIT_SIZE, UNIT_SIZE + (UNIT_SIZE / 2), i * UNIT_SIZE + UNIT_SIZE, UNIT_SIZE + (UNIT_SIZE / 2));
		}
	}
	
	/**
	 * Stores the locations of the cars in an array.
	 */
	public void generateCars() {
		// Road one
		roadOneX[0] = roadOneStart;
		roadOneX[1] = roadOneStart + UNIT_SIZE * 3;
		roadOneX[2] = roadOneStart + UNIT_SIZE * 6;
		roadOneX[3] = roadOneStart + UNIT_SIZE * 9;
		roadOneX[4] = roadOneStart + UNIT_SIZE * -3;
		roadOneX[5] = roadOneStart + UNIT_SIZE * -6;
		roadOneX[6] = roadOneStart + UNIT_SIZE * -9;
		
		// Road two
		roadTwoX[0] = roadTwoStart;
		roadTwoX[1] = roadTwoStart + UNIT_SIZE * 3;
		roadTwoX[2] = roadTwoStart + UNIT_SIZE * 6;
		roadTwoX[3] = roadTwoStart + UNIT_SIZE * 12;
		roadTwoX[4] = roadTwoStart + UNIT_SIZE * 15;
		roadTwoX[5] = roadTwoStart + UNIT_SIZE * 18;
		
		// Road three
		roadThreeX[0] = roadOneStart;
		roadThreeX[1] = roadOneStart + UNIT_SIZE * 6;
		roadThreeX[2] = roadOneStart + UNIT_SIZE * -3;
		roadThreeX[3] = roadOneStart + UNIT_SIZE * -9;
	}
	
	/**
	 * Moves the cars across the screen.
	 */
	public void moveCars() {
		roadOneStart += UNIT_SIZE;
		roadTwoStart -= UNIT_SIZE;
		
		// Moves top road
		if (roadOneStart > SCREEN_WIDTH - UNIT_SIZE)
			roadOneStart = 0;
		for (int i = 0; i < 7; i++) {
			roadOneX[i] += UNIT_SIZE;
		}
		
		// Moves middle road
		if (roadTwoStart < SCREEN_WIDTH * -1)
			roadTwoStart = 0;
		for (int i = 0; i < 6; i++) {
			roadTwoX[i] += UNIT_SIZE;
		}
	}
	
	/**
	 * Reads player's directional input and moves player accordingly.
	 */
	public void move() {
		switch(direction) {
		case 'U':
			chickenY -= UNIT_SIZE;
			break;
		case 'D':
			chickenY += UNIT_SIZE;
			break;
		case 'L':
			chickenX -= UNIT_SIZE;
			break;
		case 'R':
			chickenX += UNIT_SIZE;
			break;
		}
	}
	
	/**
	 * Checks the players position against all values in the cars array to see if the player has collided with any cars.
	 */
	public void checkCollisions() {
		// Check for collisions in first road
		for (int i = 0; i < 7; i++) {
			if (chickenX == roadOneX[i] && chickenY == UNIT_SIZE)
				running = false;
		}
		
		// Check for collisions in second road
		for (int i = 0; i < 6; i++) {
			if (chickenX == roadTwoX[i] && chickenY == UNIT_SIZE * 3)
				running = false;
		}
		
		// Check for collisions in third road
		for (int i = 0; i < 4; i++) {
			if (chickenX == roadThreeX[i] && chickenY == UNIT_SIZE * 5)
				running = false;
		}
		
		// Check for win
		if (chickenY == 0)
			running = false;
	}
	
	/**
	 * Displayes "Game Over" if a collision with a car is detected.
	 * @param g	Graphics object for drawing.
	 */
	public void gameOver(Graphics g) {
		// Game over text
		g.setColor(Color.RED);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
		
		// Draw restart button
		endbutton.setBounds(UNIT_SIZE * 4, UNIT_SIZE * 5, UNIT_SIZE * 3, UNIT_SIZE);
		endbutton.setBackground(Color.RED);
		endbutton.addActionListener(this);
		this.add(endbutton);
	}
	
	/**
	 * Runs the game
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			checkCollisions();
			moveCars();
			generateCars();
			move();
			checkCollisions();
			repaint();	// Updates the running state of the game.
		}
		
		// Reset players movement value to return player to a static position.
		direction = 'N';	
		
		// Create new game if button is pressed
		if (e.getSource() == endbutton) {
			// Get the top-level window that contains this panel.
			JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
			// Dispose of the current frame.
			currentFrame.dispose();
			// Create a new GameFrame (assuming your GameFrame constructor sets everything up).
			new GameFrame();	
		}
	}
	
	/**
	 * Detects player's movement direction.
	 */
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(chickenX > 0)
					direction = 'L';
				break;
			case KeyEvent.VK_RIGHT:
				if(chickenX < (SCREEN_WIDTH - UNIT_SIZE))
					direction = 'R';
				break;
			case KeyEvent.VK_DOWN:
				if(chickenY < (SCREEN_HEIGHT - UNIT_SIZE))
					direction = 'D';
				break;
			case KeyEvent.VK_UP:
				if(chickenY != 0)	
					direction = 'U';
				break;
			}
		}	
	}
}