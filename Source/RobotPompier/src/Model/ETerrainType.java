package Model;

public enum ETerrainType {
		Herbe,
		Neige,
		Eau,
		Foret,
		Rocher,
		Boue,
		Air;
		private Cell cell;

	
	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}
}