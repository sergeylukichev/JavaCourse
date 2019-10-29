package de.telran.transformer;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class WordsTransformerTest {

    @Test
    public void testlength3Uppercase(){
        String input = "aaA bB ccdE";
        String expected = "AAA bB ccdE";
        String actual = WordsTransformer.transform(input);

        assertEquals("Wrog result sentence", expected, actual);

    }

}
