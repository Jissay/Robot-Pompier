package Model.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Cell;
import Model.Map;
import Model.Robot;

/**
 * Algorithm steps -
 * 
 * 	1. Starting the search
 * 
 * @author Jissay
 *
 */
public class Astar extends Algorithm {

	/**
	 * Astar algorithm
	 */
	
	public Astar() {
		setName("Astar");
	}
	
	private static ArrayList<Cell> reconstructPath(HashMap<Cell, Cell> cameFrom, Cell currentNode) {
		if (cameFrom.containsKey(currentNode)) {
			ArrayList<Cell> res = new ArrayList<Cell>();
			res.add(currentNode);
			res.addAll(reconstructPath(cameFrom, cameFrom.get(currentNode)));
			return res;
		} else {
			return null;
		}
	}
	
	/**
	 * @see Algorithm.findBestWay
	 */
	public static ArrayList<Cell> findBestWay(Map map, Robot robot, Cell cellToReach) {
		Cell start = robot.getCell();
		ArrayList<Cell> closedset = new ArrayList<Cell>();
		ArrayList<Cell> openset = new ArrayList<Cell>();
		HashMap<Cell, Cell> cameFrom = new HashMap<Cell, Cell>();
		HashMap<Cell, Integer> gScore = new HashMap<Cell, Integer>();
		HashMap<Cell, Integer> hScore = new HashMap<Cell, Integer>();
		HashMap<Cell, Integer> fScore = new HashMap<Cell, Integer>();
		
		openset.add(start);
		gScore.put(start, 0);
		hScore.put(start, robot.computeDistance(cellToReach));
		fScore.put(start, gScore.get(start) + hScore.get(start));
		
		while (!openset.isEmpty()) {
			Cell current = openset.get(0);
			int minCurrent = fScore.get(current);
			for (Cell c: openset) {
				if (fScore.get(c) < minCurrent) {
					minCurrent = fScore.get(c);
					current = c;
				}
			}
			
			if (current.equals(cellToReach))
				return reconstructPath(cameFrom, current);
			
			openset.remove(current);
			closedset.add(current);
			for (Cell c: current.getListCellulesAdjacentes()) {
				if (closedset.contains(c))
					continue;
				
				boolean tentativeIsBetter;
				int tentativeGScore = gScore.get(current) + current.distance(c);
				
				if (!openset.contains(c)) {
					openset.add(c);
					hScore.put(c, c.distance(cellToReach));
					tentativeIsBetter = true;
				} else if (tentativeGScore < gScore.get(c)) {
					tentativeIsBetter = true;
				} else {
					tentativeIsBetter = false;
				}
				
				if (tentativeIsBetter) {
					cameFrom.put(c, current);
					gScore.put(c, tentativeGScore);
					fScore.put(c, tentativeGScore + hScore.get(c));
				}
			}
		}
		
		return null;
	}
}
