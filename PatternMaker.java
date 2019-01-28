/**
 *  
 * @author:		 	Nisha Chandra	 
 */

import java.awt.Color;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class PatternMaker
{
	/** Dimensions for the different worlds */
	public static final int NUM_ROWS_NUMBER_GRID = 10;
	public static final int NUM_COLS_NUMBER_GRID = 10;
	
	public static final int NUM_ROWS_COLOR_GRID = 19;
	public static final int NUM_COLS_COLOR_GRID = 19;
	
	/** Draw the different patterns. Comment others out while working on a single pattern.
	 *  Uncomment calls to completed patterns before turning in.
	 */	
	public static void main(String[] args)
	{
		drawPattern1(NUM_ROWS_NUMBER_GRID, NUM_COLS_NUMBER_GRID);
		drawPattern2(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
		drawPattern3(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
	//	drawPattern4(NUM_ROWS_COLOR_GRID, NUM_COLS_COLOR_GRID);
	}
	

	// Draw the number patterns
	public static void drawPattern1(int numRows, int numCols)
	{
		BoundedGrid<Integer> grid = new BoundedGrid<Integer>(numRows, numCols);
		World<Integer> world = new World<Integer>(grid);
		
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col <= row; col++)
			{
				Location myLoc = new Location(row, col);
				world.add(myLoc, col);
			}
		}

		world.show();
	}

	
	// Draw the triangles with the diagonal in different color
	public static void drawPattern2(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		// draw colors for left half and diagonal row
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col <= row; col++)
			{
				if (row == col)
				{
					Location loc = new Location(row, col);
					world.add(loc, Color.black);
				}
				
				else
				{
					Location loc = new Location(row, col);
					world.add(loc, Color.cyan);
				}
			}
		}
		
		// draw colors for right half of the square
		for (int row = (numRows - 1); row >= 0; row--)
		{
			for (int col = (numCols - 1); col > row; col--)
			{
					Location loc = new Location(row, col);
					world.add(loc, Color.pink);
			
			}
		}
		
		
		
		world.show();
	}
	
	// Draw the colored lines
	public static void drawPattern3(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		for (int col = 0; col < numCols; col++)
		{
			for (int row = 0; row < numRows; row++)
			{		
					switch (col)
					{
						case 0: case 3: case 6: case 9:
						case 12: case 15: case 18:
							Location loc = new Location(row, col);
							world.add(loc, Color.red);
							break;
							
						case 1: case 4: case 7: case 10:
						case 13: case 16:
							loc = new Location(row, col);
							world.add(loc, Color.white);
							break;
							
						case 2: case 5: case 8: case 11:
						case 14: case 17:
							loc = new Location(row, col);
							world.add(loc, Color.blue);
							break;
					}
			}
		}				
		
		world.show();
	}
	

	public static void drawPattern4(int numRows, int numCols)
	{
		BoundedGrid<Color> grid = new BoundedGrid<Color>(numRows, numCols);
		World<Color> world = new World<Color>(grid);
		
		
		world.show();
	}
}