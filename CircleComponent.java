/**
 *	The CircleComponent class provides the functionality for drawing
 *	the 100 circles of different sizes.  The rectangle window can be
 *	stretched and the circles are drawn to the new window size.
 *
 */
 
// All class imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class CircleComponent extends JComponent
{
	// Constant Values for this class
	public static final int MAX_DIAMETER = 50;
	public static final int MIN_DIAMETER = 20;
	
	// Width and Height of the component window
	private int width;
	private int height;
	
	@Override
	public void paintComponent(Graphics g)
	{
		// Recover Graphics2D object
		Graphics2D g2 = (Graphics2D) g;

		// Get size of component window
		width = getWidth();
		height = getHeight();

		Ellipse2D.Double circle;
		Color randomColor;
		
		// Draw 100 circles within the component windows in different colors
		
		for (int count = 1; count <= 100; count++)
		{
			circle = generateCircle(width, height);
			randomColor = getRandomColor();
			g2.setColor (randomColor);
			g2.fill(circle);
			g2.draw(circle);
		}


	}

	/**
	 *	The generateCircle method is called to draw the circles based on the size
	 *	of the enclosing window.
	 *	
	 *	@param comWidth is the width of the main window
	 *	@param comHeight is the height of the main window
	 *	@return the circle generated based on the provided dimensions and diameter
	 *
	 */
	 
	private Ellipse2D.Double generateCircle(int comWidth, int comHeight)
	{
		int diameter = (int) (Math.random() * (MAX_DIAMETER + 1 - MIN_DIAMETER)) + MIN_DIAMETER;
		int x = getRandomInteger((diameter), (comWidth - diameter));
		int y = getRandomInteger((diameter), (comHeight - diameter));		
		Ellipse2D.Double circle = new Ellipse2D.Double (x, y, diameter, diameter);
		return circle;
	}
	
	/**
	 * 	The getRandomInteger method returns a random number based on the minimum and 
	 *	maximum values inclusive
	 *
	 *	@min minimum value of the range
	 *	@max maximum value of the range
	 *	return the random number of type int
	 */
	 
	private int getRandomInteger(int min, int max)
	{
		int randNum = (int) (Math.random() * (max + 1 - min)) + min;
		return randNum;
	}
	
	/**
	 * 	The getRandomColor generates random color for the fill used in the circle
	 *
	 *	return a value of type Color
	 */
	 
	private Color getRandomColor()
	{
		Color randomColor = new Color ((float) Math.random(), (float) Math.random(), (float) Math.random());
		return randomColor;
	}

}