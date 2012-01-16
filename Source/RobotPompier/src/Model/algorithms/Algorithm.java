/**
 * 
 */
package Model.algorithms;

import java.util.ArrayList;

import Model.Cell;
import Model.Map;
import Model.Robot;

/** 
 *
 * @author Marc
 */
public abstract class Algorithm {
	/** 
	 * 
	 * @param Map map - Actual map to run
	 * @param RobotConcret robot - Robot that have to reach the targeted cell
	 * @param Cell cell - Cell to reach with Pathfinding algorithm
	 * @return ArrayList<Cell> - List of Cell to reach in order to follow the path found
	 */
	public ArrayList findBestWay(Map map, Robot robot, Cell cell) {

		return null;
	}
}