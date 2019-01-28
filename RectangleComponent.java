/**
 *	The RectangleComponent class provides the functionality for drawing
 *	several rectangles within the rectangular enclosing box.
 *
 *	@author: Nisha P. Chandra
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class RectangleComponent extends JComponent
{
	// Constants for this class
	private static final int MIN_WIDTH = 10;
	private static final int MIN_HEIGHT = 5;
	private static final int STARTING_COORD_20LESS = 20;
	private static final int OVERALL_RECT_REDUCED_MINUS_FORTY = 40;
	
	// Width and height of the component window
	int width;
	int height;
	
	@Override
	public void paintComponent(Graphics g)
	{
		// Recover Graphics2D object
		Graphics2D g2 = (Graphics2D) g;
		
		// Get size of component window
		width = getWidth();
		height = getHeight();

		// starting coordinates of the box
		Color randomColor;
		Rectangle box;
		int posX = 0; 
		int posY = 0;
		
		// Draw rectangle until the width or the height meets the minimum requirement
		// of Width >= 10 pix and height >= 5 pix
		
		while ((width >= MIN_WIDTH) || (height >= MIN_HEIGHT))
		{
			randomColor = new Color ((float)Math.random(), (float)Math.random(),
							(float)Math.random());
			g2.setColor (randomColor);
			box = new Rectangle (posX,posY,(width),(height));
			g2.fill(box);
			width -= OVERALL_RECT_REDUCED_MINUS_FORTY;
			height -= OVERALL_RECT_REDUCED_MINUS_FORTY;
			posX += STARTING_COORD_20LESS;
			posY += STARTING_COORD_20LESS;
		}
		
	}
}