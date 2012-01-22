package Model;

public interface IMoveType {
	float weight = 0;

	public float vitesse(float inclinaison, ETerrainType terrainType);
}