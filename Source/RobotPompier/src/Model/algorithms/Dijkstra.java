package Model.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import Model.Cell;
import Model.Map;
import Model.Robot;

public class Dijkstra extends Algorithm {
	
	private class DjikstraCell {
		public Cell			_cell;
		public int			_parcouru;
		public DjikstraCell	_precedent;
	}

	public Dijkstra() {
		setName("Dijkstra");
	}

	public ArrayList<Cell> findBestWay(Map map, Robot robot, Cell cellToReach) {
		HashMap<Cell, DjikstraCell> cells = new HashMap<Cell, DjikstraCell>();
		DjikstraCell currentCell = null;
		DjikstraCell toReach = null;
		for (ArrayList<Cell> lc: map.getCell()) {
			for (Cell c: lc) {
				DjikstraCell tmpCell = new DjikstraCell();
				tmpCell._cell = c;
				tmpCell._parcouru = Integer.MAX_VALUE;
				cells.put(c, tmpCell);
				if (c.equals(robot.getCell()))
					currentCell = tmpCell;
				if (c.equals(cellToReach))
					toReach = tmpCell;
				tmpCell._precedent = null;
			}
		}
		
		currentCell._parcouru = 0;
		
		Collection<DjikstraCell> notVisited = cells.values();
		while (!notVisited.isEmpty()) {
			// Recherche du parcouru minimum
			DjikstraCell curr = null;
			int min = Integer.MAX_VALUE;
			for (DjikstraCell dc: notVisited) {
				if (dc._parcouru <= min) {
					min = dc._parcouru;
					curr = dc;
				}
			}
			notVisited.remove(curr);
			ArrayList<DjikstraCell> adjacents = new ArrayList<Dijkstra.DjikstraCell>();
			for (Cell adjc: curr._cell.getListCellulesAdjacentes()) {
				adjacents.add(cells.get(adjc));
			}
			
			for (DjikstraCell c: adjacents) {
				if (c._parcouru > curr._parcouru + curr._cell.distance(cellToReach) * robot.getRobotType().getMoveType().getCost(0, c._cell.getTerrainType())) {
					c._parcouru = (int) (curr._parcouru + curr._cell.distance(cellToReach) * robot.getRobotType().getMoveType().getCost(0, c._cell.getTerrainType()));
					c._precedent = curr;
					notVisited.add(c);
				}
			}
		}
		ArrayList<Cell> res = new ArrayList<Cell>();
		DjikstraCell currCell = toReach;
		while (!currCell.equals(currentCell)) {
			res.add(currCell._cell);
			currCell = currCell._precedent;
		}
		
		Collections.reverse(res);
		return res;
	}
}
