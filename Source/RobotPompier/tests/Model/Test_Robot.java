package Model;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class Test_Robot extends TestCase {

	@Test
	public void testInstanciation() {
		Robot robot = new Robot();
		assertEquals(robot.isFree(), true);
	}

}
