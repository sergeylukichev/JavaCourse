package de.telran.calc;

public class Calc {

	/*
	 * Only makes the testSingleNumber() pass
	 * 
	public static Integer sum(String s) {
		return Integer.parseInt(s);
	}
	*/
	
	/*
	 * Only makes the testTwoNumbers() pass,
	 * but fails testSingleNumber()
	 * 
	public static Integer sum(String s) {
	String [] numbers = s.split(",");
		return Integer.parseInt(numbers[0]) 
		+ Integer.parseInt(numbers[1]);
	}
	*/

	
	//the final function, which makes all tests pass
	public static Integer sum(String s) {
		String [] numbers = s.split(",");
		
		Integer ret = 0;
		for(String st:numbers) {
			ret += Integer.parseInt(st);
		}
		return ret;
	}
}
