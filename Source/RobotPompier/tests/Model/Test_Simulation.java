package Model;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class Test_Simulation extends TestCase {

	@Test
	public void testInstanciation() {
		Simulation simulation = new Simulation();
		assertNotNull(simulation.getListAlgorithms());
		assertNotNull(simulation.getListMoveTypes());
		assertNotNull(simulation.getListProjectorTypes());
		assertNotNull(simulation.getManager());
		assertNotNull(simulation.getRobotModel());
	}

}
