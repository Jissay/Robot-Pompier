/**
 * 
 */
package Model;

import java.util.ArrayList;

/** 
 * @author Marc
 */
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
	
	/**
	 * Méthode générant une map aléatoire, dans l'attribut _cells.
	 */
	private void generateMapArrayLists() {
		// Create Lists
		_cells = new ArrayList<ArrayList<Cell>>();
		
		for (int i = 0; i < _longueur; i++) {
			// Creation de la liste contenant les cases, d'un nombre égal à la largueur de la map,
			// pour chaque unité de longueur
			ArrayList<Cell> cellsContainer = new ArrayList<Cell>();
			
			// Parcours de la nouvelle liste pour ajouter des cellles jusqu'à la largeur donnée
			for (int j = 0; j < _largeur; j++) {
				Cell c = new Cell();
				
				// Set terrain par defaut
				c.setTerrainType(ETerrainType.Herbe);
				c.setX(i); // Définit l'emplacement de la liste contenant la cellule dans l'ArrayList<ArrayList<Cell>>
				c.setY(j); // Définit l'emplacement de la cellule dans l'ArrayList<Cell>
				
				cellsContainer.add(c);
			}
			_cells.add(cellsContainer);
		}
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