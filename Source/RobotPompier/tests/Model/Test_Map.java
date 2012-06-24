package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Test_Map {

	@Test
	public void testInstanciation() {
		Map map = new Map();
		assertNotNull(map.getCell());
		assertNotNull(map.getLargeur());
		assertNotNull(map.getLongueur());
	}
	
	@Test
	public void testSetOnFireAt() {
		Map map = new Map();
		map.getCell().set(0, new ArrayList<Cell>());
		map.getCell().get(0).set(0, new Cell());
		assertEquals(map.getCell().get(0).get(0).isOnFire(), false);
		map.setOnFireAt(0, 0, 1);
		assertEquals(map.getCell().get(0).get(0).isOnFire(), true);
	}

	@Test
	public void testSetRobotAt() {
		fail("Not yet implemented");
	}
}
