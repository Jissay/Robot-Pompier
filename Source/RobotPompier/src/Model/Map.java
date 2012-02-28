package Model;

import java.util.ArrayList;

public class Map {
	
	private int _largeur;
	private int _longueur;
	private ArrayList<ArrayList<Cell>> _cells;
	private Manager _manager;
	
	public Map(int longueur, int largeur) {
		_longueur = longueur;
		_largeur = largeur;
		
		generateMapArrayLists();
	}
	
	private void generateMapArrayLists() {
		// Create Lists
		_cells = new ArrayList<ArrayList<Cell>>();
		
		for (int i = 0; i < _longueur; i++) {
			// Creation de la liste contenant les cases, d'un nombre �gal � la largueur de la map,
			// pour chaque unit� de longueur
			ArrayList<Cell> cellsContainer = new ArrayList<Cell>();
			
			// Parcours de la nouvelle liste pour ajouter des cellles jusqu'� la largeur donn�e
			for (int j = 0; j < _largeur; j++) {
				Cell c = new Cell();
				
				// Set terrain par defaut
				c.setTerrainType(ETerrainType.GRASS);
				c.setX(i); // D�finit l'emplacement de la liste contenant la cellule dans l'ArrayList<ArrayList<Cell>>
				c.setY(j); // D�finit l'emplacement de la cellule dans l'ArrayList<Cell>
				
				cellsContainer.add(c);
			}
			_cells.add(cellsContainer);
		}
	}
	
	private void addRandomFires() {
		// A MODIFIER
		_cells.get(5).get(5).setOnFire(3);
	}
	
	/* ------------------- */
	/* GETTERS AND SETTERS */
	/* ------------------- */
	public int getLargeur() {
		return _largeur;
	}
	public void setLargeur(int largeur) {
		_largeur = largeur;
	}
	public int getLongueur() {
		return _longueur;
	}
	public void setLongueur(int longueur) {
		_longueur = longueur;
	}
	public ArrayList<ArrayList<Cell>> getCell() {
		return _cells;
	}
	public void setCell(ArrayList<ArrayList<Cell>> cell) {
		_cells = cell;
	}
	public Manager getManager() {
		return _manager;
	}
	public void setManager(Manager manager) {
		_manager = manager;
	}
}