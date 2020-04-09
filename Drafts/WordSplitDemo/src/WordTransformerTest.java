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

    @Test
    public void testTransformRule5() {
        //test data
        String input = "aaa bcDEF eklm iiiOP";

        //call method we test with test data
        String actual = WordTransformer.transform(input, new TransformerRuleLength5());

        //expected result
        String expected = "aaa bcdef eklm iiiop";

        //compare actual and expected
        assertEquals("string length", expected.length(), actual.length());
        assertEquals(expected, actual);
    }

}
