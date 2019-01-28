/**
 *	The CircleComponent class provides the functionality for drawing
 *	the 1000 circles of different sizes.  The circles are generated and
 * 	stored in the ArrayList before they are drawn. The rectangle window can be
 *	stretched and the circles are drawn to the new window size.
 *
 *	@author: Nisha P. Chandra
 */
 
// All class imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import java.util.List;
import java.util.ArrayList;

public class CirclesComponent extends JComponent
{
	// ArrayList to hold the 1000 circles 
	List<Ellipse2D.Double> circles; 
	
	// Constant Values for this class
	public static final double MAX_DIAMETER = 61;
	public static final double MIN_DIAMETER = 1;
	
	// Width and Height of the component window
	private int width;
	private int height;
	
	// Constructor
	public CirclesComponent()
	{
		circles = new ArrayList<Ellipse2D.Double>();
	}

	/**
	 *  Generate and draw all of the circles
	 *  @param g the graphics object for drawing
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		// Get the width and height of the component window
		width = getWidth();
		height = getHeight();				
		
		Graphics2D g2 = (Graphics2D) g;
		generateCircles();
		drawCircles(g2);
	}
	
	/**
	 *	The generateCircles method is called to generate 1000 circles based on the size
	 *	of the enclosing window and stores them in the ArrayList.
	 *	
	 *	@return none
	 *
	 */	 
	private void generateCircles()
	{	
		double diameter = 0.0;
		double x = 0.0;
		double y = 0.0;
		circles = new ArrayList<Ellipse2D.Double>();
		
		for (int count = 0; count < 1000; count++)
		{
			diameter = Math.random() * (MAX_DIAMETER - MIN_DIAMETER) + MIN_DIAMETER;
			x = getRandomDouble((diameter), (width - diameter));
			y = getRandomDouble((diameter), (height - diameter));		
			circles.add (new Ellipse2D.Double (x, y, diameter, diameter));
		}
	}

	/**
	 *	The drawCircles method is called to draw 1000 circles based on the size
	 *	of the enclosing window and using the circles stored in the ArrayList.
	 *	Uses randomly generated color for the circles.
	 *	
	 *  @min minimum value of the range
	 *	@return none
	 *
	 */	 	
	private void drawCircles(Graphics2D g2)
	{
			for (int count = 0; count < 1000; count++)
			{
				g2.setColor (getRandomColor());
				g2.fill(circles.get(count));
				g2.draw(circles.get(count));
			}
	}		

	// 100-point Version
	private boolean circleIntersects(Ellipse2D.Double circle)
	{
		return true;
	}
	
	/**
	 * 	The getRandomDouble method returns a random number based on the minimum and 
	 *	maximum values inclusive
	 *
	 *	@min minimum value of the range
	 *	@max maximum value of the range
	 *	@return the random number of type double
	 */
	 
	private double getRandomDouble(double min, double max)
	{
		double randNum = Math.random() * (max - min) + min;
		return randNum;
	}
	
	/**
	 * 	The getRandomColor generates random color for the fill used in the circle
	 *
	 *	@return value of type Color
	 */
	 
	private Color getRandomColor()
	{
		Color randomColor = new Color ((float) Math.random(), (float) Math.random(), (float) Math.random());
		return randomColor;
	}

}