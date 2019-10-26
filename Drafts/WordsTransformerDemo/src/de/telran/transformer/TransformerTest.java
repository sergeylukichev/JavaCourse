package de.telran.transformer;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class TransformerTest {

    @Test
    public void testLentgh3UpperCase() {
        String input = "aaa bB ccdE";
        String expected = "AAA bB ccdE";

        String actual = Transformer.transform(input);

        assertEquals("wrong result sentence", expected, actual);

    }

    @Test
    public void testLentgh3UpperCaseSingleWord() {
        String input = "abc";
        String expected = "ABC";

        String actual = Transformer.transform(input);

        assertEquals("wrong result sentence", expected, actual);

    }

    @Test
    public void testLength4LowerCaseNew() {
        String input = "aaa bB CCDE";
        String expected = "aaa bB ccde";

        Predicate<String> p = s -> s.length() == 4;
        Function<String, String> f = s -> s.toLowerCase();

        String actual = Transformer.transform(input, p, f);

        assertEquals("wrong result sentence", expected, actual);
    }

    @Test
    public void testLength3UpperCaseNew() {
        String input = "aaa bB ccdE";
        String expected = "AAA bB ccdE";

        Predicate<String> p = s -> s.length() == 3;
        Function<String, String> f = s -> s.toUpperCase();

        String actual = Transformer.transform(input, p, f);

        assertEquals("wrong result sentence", expected, actual);
    }
}
