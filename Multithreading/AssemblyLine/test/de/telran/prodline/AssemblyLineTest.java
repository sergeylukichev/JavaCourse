package de.telran.prodline;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AssemblyLineTest {

	@Test
	public void testAssemblyLineCapacityConstraint() {
		AssemblyLine line = AssemblyLine.getInstance();
		line.buildCar();
		
		int maxPartsOnLine = 0;
		while(line.isRunning()) {
			int currentPartsOnLine = line.currentLane.size();
			if(currentPartsOnLine > maxPartsOnLine) {
				maxPartsOnLine = currentPartsOnLine;
			}
		}
		
		assertEquals(3, maxPartsOnLine);
		assertEquals(1, line.carsBuilt.size());
	}
}
