/**
 *	This main client class uses both the CircleComponent and the
 *	RectangleComponent classes to draw two windows with circles and rectangles.
 *	The window size can be changed.	
 *
 *	@author: Nisha P. Chandra
 */

// Import classes 
  
import javax.swing.JFrame;
 
public class GraphicsLab
{
	public static void main(String[] args)
 	{
 		final int FRAME_WIDTH = 550;
 		final int FRAME_HEIGHT = 350;

 		// Instantiate and define JFrame
 		JFrame frame = new JFrame();
 		
 		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
 		frame.setLocation(5, 5);
 		frame.setTitle("Graphics Lab");
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                     
 		
 		// Draw circles
 		CircleComponent component = new CircleComponent();
 		frame.add(component);
 		
 		// Show frame
 		frame.setVisible(true);


		// Show the rectangles in a separate frame for BONUS 
  		JFrame bonusFrame = new JFrame();
  		bonusFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
 		bonusFrame.setLocation(5, FRAME_HEIGHT + 10);
 		bonusFrame.setTitle("Rectangles");
 		bonusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		bonusFrame.add(new RectangleComponent());
 		bonusFrame.setVisible(true);

	}
}