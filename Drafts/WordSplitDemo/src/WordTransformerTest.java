import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordTransformerTest {

    @Test
    public void testTransform() {
        //test data
        String input = "aaa bcDE eklm iii";

        //call method we test with test data
        String actual = WordTransformer.transform(input);

        //expected result
        String expected = "AAA bcDE eklm III";

        //compare actual and expected
        assertEquals("string length", expected.length(), actual.length());
        assertEquals(expected, actual);

    }
}
