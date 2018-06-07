package de.telran.transformer;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.telran.transformer.Transformer;

public class TransformerTest {
	
	String sentence;
	Function<String, String> toUpperCase = s -> s.toUpperCase();
	Predicate<String> isThree = t -> t.length() == 3;
	
	Function<String, String> toLowerCase = s -> s.toLowerCase();
	Predicate<String> isFour = t -> t.length() == 4;	
	
	@Before
	public void before() {
		sentence = "sss DDDD NNN aBc";
	}
	
	@Test
	public void testOneWordSentenceToUpper() {
		String input = "aAb";							
		String expected = "AAB";
		String actual = Transformer.transform(input, toUpperCase, isThree);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testOneWordSentenceToLower() {
		
		String input = "AbCd";
		
		String expected = "abcd";
		
		String actual = Transformer.transform(input, toLowerCase, isFour);
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testMultipleWordsToUpper() {
		String expected = "SSS DDDD NNN ABC";
		
		String actual = Transformer.transform(sentence, toUpperCase, isThree);
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testMultipleWordsToLower() {
		String expected = "sss dddd NNN aBc";
		
		String actual = Transformer.transform(sentence, toLowerCase, isFour);
		
		assertEquals(expected, actual);
	}
	
	@Test
	@Ignore("Lets assume we do not know yet how to handle null inputs")
	public void testIfNullInput () {
		Transformer.transform(null, toLowerCase, isFour);
	}
}
