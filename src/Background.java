import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Class containing the drawing instructions for a winning screen.
 */
public class Background extends JPanel{

	/**
	 * Draws the winning screen.
	 * @param g	Graphics object for drawing.
	 * @param SCREEN_WIDTH	Final constant for screen width.
	 * @param SCREEN_HEIGHT	Final constant for screen height.
	 * @param UNIT_SIZE	Final constant for unit size.
	 */
	public static void paintComponent(Graphics g, int SCREEN_WIDTH, int SCREEN_HEIGHT, int UNIT_SIZE) {
		Random rand = new Random();	// Creates random object.
		
		// Draw setting
		// Sky
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, SCREEN_WIDTH, UNIT_SIZE);
		
		// Fireworks
		for (int i = 0; i < 10; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE);
			g.setColor(Color.GREEN);
			g.fillOval(dimX, dimY, 10, 10);
			g.setColor(Color.BLACK);
			g.drawOval(dimX, dimY, 10, 10);
		}
		for (int i = 0; i < 10; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE);
			g.setColor(Color.RED);
			g.fillOval(dimX, dimY, 10, 10);
			g.setColor(Color.BLACK);
			g.drawOval(dimX, dimY, 10, 10);
		}
		for (int i = 0; i < 10; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE);
			g.setColor(Color.BLUE);
			g.fillOval(dimX, dimY, 10, 10);
			g.setColor(Color.BLACK);
			g.drawOval(dimX, dimY, 10, 10);
		}
		for (int i = 0; i < 10; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE);
			g.setColor(Color.YELLOW);
			g.fillOval(dimX, dimY, 10, 10);
			g.setColor(Color.BLACK);
			g.drawOval(dimX, dimY, 10, 10);
		}
		for (int i = 0; i < 10; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE);
			g.setColor(Color.MAGENTA);
			g.fillOval(dimX, dimY, 10, 10);
			g.setColor(Color.BLACK);
			g.drawOval(dimX, dimY, 10, 10);
		}
		
		// Rocks
		Color ROCK = new Color(192, 192, 192);
		for (int i = 0; i < 25; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE) + (SCREEN_HEIGHT - UNIT_SIZE) - UNIT_SIZE;
			g.setColor(Color.GRAY);
			g.fillOval(dimX, dimY, 5, 5);
		}
		for (int i = 0; i < 25; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE) + (SCREEN_HEIGHT - UNIT_SIZE) - UNIT_SIZE;
			g.setColor(ROCK);
			g.fillOval(dimX, dimY, 5, 5);
		}
		for (int i = 0; i < 25; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE) + (SCREEN_HEIGHT - UNIT_SIZE) - (UNIT_SIZE * 3);
			g.setColor(Color.GRAY);
			g.fillOval(dimX, dimY, 5, 5);
		}
		for (int i = 0; i < 25; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE) + (SCREEN_HEIGHT - UNIT_SIZE) - (UNIT_SIZE * 3);
			g.setColor(ROCK);
			g.fillOval(dimX, dimY, 5, 5);
		}
		for (int i = 0; i < 25; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE) + (SCREEN_HEIGHT - UNIT_SIZE) - (UNIT_SIZE * 5);
			g.setColor(Color.GRAY);
			g.fillOval(dimX, dimY, 5, 5);
		}
		for (int i = 0; i < 25; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE) + (SCREEN_HEIGHT - UNIT_SIZE) - (UNIT_SIZE * 5);
			g.setColor(ROCK);
			g.fillOval(dimX, dimY, 5, 5);
		}
		
		// Grass
		g.setColor(Color.GREEN);
		g.fillRect(0, SCREEN_HEIGHT - UNIT_SIZE, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		// Flowers
		for (int i = 0; i < 25; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE) + (SCREEN_HEIGHT - UNIT_SIZE);
			g.setColor(Color.MAGENTA);
			g.fillOval(dimX, dimY, 5, 5);
			g.setColor(Color.WHITE);
			g.drawOval(dimX, dimY, 5, 5);
		}
		for (int i = 0; i < 25; i++) {
			int dimX = rand.nextInt(SCREEN_WIDTH);
			int dimY = rand.nextInt(UNIT_SIZE) + (SCREEN_HEIGHT - UNIT_SIZE);
			g.setColor(Color.YELLOW);
			g.fillOval(dimX, dimY, 5, 5);
			g.setColor(Color.WHITE);
			g.drawOval(dimX, dimY, 5, 5);
		}
		
		// Roads
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, UNIT_SIZE * 5, SCREEN_WIDTH, UNIT_SIZE);
		g.fillRect(0, UNIT_SIZE * 3, SCREEN_WIDTH, UNIT_SIZE);
		g.fillRect(0, UNIT_SIZE, SCREEN_WIDTH, UNIT_SIZE);
		
		//Road lines
		for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
			g.setColor(Color.YELLOW);
			g.drawLine(i * UNIT_SIZE, UNIT_SIZE * 5 + (UNIT_SIZE / 2), i * UNIT_SIZE + UNIT_SIZE, UNIT_SIZE * 5 + (UNIT_SIZE / 2));
			i++;
		}
		for (int i = 1; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
			g.setColor(Color.YELLOW);
			g.drawLine(i * UNIT_SIZE, UNIT_SIZE * 3 + (UNIT_SIZE / 2), i * UNIT_SIZE + UNIT_SIZE, UNIT_SIZE * 3 + (UNIT_SIZE / 2));
			i++;
		}
		for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
			g.setColor(Color.YELLOW);
			g.drawLine(i * UNIT_SIZE, UNIT_SIZE + (UNIT_SIZE / 2), i * UNIT_SIZE + UNIT_SIZE, UNIT_SIZE + (UNIT_SIZE / 2));
			i++;
		}
	}	
}
