package Model.algorithms;

import java.util.ArrayList;

import Model.Cell;
import Model.Map;
import Model.Robot;

public abstract class Algorithm {
	
	private String _name;
	
	/** 
	 * 
	 * @param Map map - Actual map to run
	 * @param RobotConcret robot - Robot that have to reach the targeted cell
	 * @param Cell cellToReach - Cell to reach with Pathfinding algorithm
	 * @return ArrayList<Cell> - List of Cell to reach in order to follow the path found
	 */
	public static ArrayList<Cell> findBestWay(Map map, Robot robot, Cell cellToReach) {
		// Cells ran by the algorithm
		ArrayList<Cell> path = new ArrayList<Cell>();
		
		// Prototype Algorithm
		Cell startCell = robot.getCell(); // Cell where the robot is
		int x_startCell = startCell.getX();
		int y_startCell = startCell.getY();
		
		int x_toReach = cellToReach.getX(); // x of the cell to reach
		int y_toReach = cellToReach.getY(); // y of the cell to reach
		
		// coord of the current cell (while moving)
		int x_currentCell = x_startCell, y_currentCell = y_startCell;
		
		// Set if difference between start coord and final coord are positive or negative
		boolean xDiffPositive, yDiffPositive;
		int xDiff = x_toReach - x_startCell;
		if (xDiff > 0) { xDiffPositive = true; } else { xDiffPositive = false; };
		
		int yDiff = y_toReach - y_startCell;
		if (yDiff > 0) { yDiffPositive = true; } else { yDiffPositive = false; };
		
		// Straight path
		while (x_currentCell != x_toReach || y_currentCell != y_toReach) {
			boolean xOk = false; // True when x_toReach have been reached
			boolean yOk = false; // True when y_toReach have been reached
			
			// Check if x or y have been reached
			if (x_currentCell == x_toReach) { xOk = true; }
			if (y_currentCell == y_toReach) { yOk = true; }
		
			// Move to next x
			if (!xOk) {
				if (xDiffPositive) {
					x_currentCell++;
				} else {
					x_currentCell--;
				}
			}
			
			// Move to next y
			if (!yOk) {
				if (yDiffPositive) {
					y_currentCell++;
				} else {
					y_currentCell--;
				}
			}
			
			// Add current cell in the list that contains cells ran by the algorithm
			path.add(new Cell(x_currentCell, y_currentCell, 0));
		}
		
		return path;
	}
	
	/* GETTERS AND SETTERS */
	
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
}