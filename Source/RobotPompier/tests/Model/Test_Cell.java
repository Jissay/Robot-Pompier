package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_Cell {

	@Test
	public void testDistance() {
		Cell cell1 = new Cell(3, 1, 1.0f);
		Cell cell2 = new Cell(5, 2, 1.0f);
		
		assertEquals(3, cell1.distance(cell2));
	}

}
