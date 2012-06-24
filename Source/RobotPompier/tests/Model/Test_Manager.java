package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_Manager {

	@Test
	public void testInstanciation() {
		Manager manager = new Manager(new Simulation());
		assertNotNull(manager.getSimulation());	
	}

}
