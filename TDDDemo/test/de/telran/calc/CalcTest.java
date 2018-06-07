package de.telran.calc;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.telran.calc.Calc;

public class CalcTest {
		
	@Before
	public void before() {
		System.out.println("Running the test");
	}
	
	@After
	public void after () {
		System.out.println("Finishing the test");
	}
	
	@Test
	public void testSingleNumber() {

		String input = "2";
		Integer expected = 2;
		Integer actual = Calc.sum(input);
		
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testTwoNumbers() {
		String input = "2,3";
		Integer expected = 5;
		Integer actual = Calc.sum(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3Numbers() {
		String input = "2,3,4";
		Integer expected = 9;
		Integer actual = Calc.sum(input);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testCharacter() {
		String input = "2,f,5";
		
		Calc.sum(input);
	}
	
	@Ignore("Test is ignored since we dont know ignore it or handle")
	@Test
	public void testNull() {
		String input = null;
		Calc.sum(input);
	}
}
