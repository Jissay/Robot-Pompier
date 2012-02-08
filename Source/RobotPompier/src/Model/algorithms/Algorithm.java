package Model.algorithms;

import java.util.ArrayList;

import Model.Cell;
import Model.Map;
import Model.Robot;

public abstract class Algorithm {
	/** 
	 * 
	 * @param Map map - Actual map to run
	 * @param RobotConcret robot - Robot that have to reach the targeted cell
	 * @param Cell cellToReach - Cell to reach with Pathfinding algorithm
	 * @return ArrayList<Cell> - List of Cell to reach in order to follow the path found
	 */
	public static ArrayList<Cell> findBestWay(Map map, Robot robot, Cell cellToReach) {
		ArrayList<Cell> path = new ArrayList<Cell>();
		
		// Prototype Algorithm
		Cell startCell = robot.getCell();
		int x_startCell = startCell.getX();
		int y_startCell = startCell.getY();
		
		int x_toReach = cellToReach.getX();
		int y_toReach = cellToReach.getY();
		
		int x_currentCell = x_startCell, y_currentCell = y_startCell;
		
		boolean xDiffPositive, yDiffPositive;
		
		if (x_toReach - x_startCell > 0) {
			xDiffPositive = true;
		} else {
			xDiffPositive = false;
		}
		
		if (y_toReach - y_startCell > 0) {
			yDiffPositive = true;
		} else {
			yDiffPositive = false;
		}
		
		while (x_currentCell != x_toReach || y_currentCell != y_toReach) {
			boolean xOk = false;
			boolean yOk = false;
			
			// Look if one of the coords is right
			if (x_currentCell == x_toReach) { xOk = true; }
			if (y_currentCell == y_toReach) { yOk = true; }
		
			if (!xOk) {
				if (xDiffPositive) {
					x_currentCell++;
				} else {
					x_currentCell--;
				}
			}
			
			if (!yOk) {
				if (yDiffPositive) {
					y_currentCell++;
				} else {
					y_currentCell--;
				}
			}
			
			path.add(new Cell(x_currentCell, y_currentCell));
		}
		
		return path;
	}
}