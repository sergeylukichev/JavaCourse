import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomLinkedListTest {
    @Test
    public void testSizeZero() {
        CustomLinkedList al = new CustomLinkedList();
        assertEquals(0, al.size());
    }

    @Test
    public void testSizeNotZero(){

        int [] ar = {1, 2, 3};
        CustomLinkedList<Integer> al = new CustomLinkedList<>();

        for(int a:ar) {
            al.append(a);
        }

        assertEquals(3, al.size());
    }

    @Test
    public void appendOneElemTest() {
        CustomLinkedList<String> cl = new CustomLinkedList<>();
        cl.append("test");
        assertEquals("size", 1, cl.size());
    }

    @Test
    public void testGetAll() {
        int [] ar = {1, 2, 3};
        CustomLinkedList<Integer> al = new CustomLinkedList<>();

        for(int a:ar) {
            al.append(a);
        }

        for(int i = 0; i < ar.length; i++) {
            assertEquals(ar[i], al.get(i).intValue());
        }

    }

    @Test
    public void testRemoveById() {
        String [] input = {"aa", "bb", "cc", "dd"};
        CustomLinkedList<String> al = new CustomLinkedList<>();

        for(String a:input) {
            al.append(a);
        }

        String expectedDeletedItem = al.removeById(2);

        String [] expected = {"aa", "bb", "dd"};

        for(int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], al.get(i));
        }

        assertEquals(3, al.size());

        assertEquals("cc", expectedDeletedItem);
    }
}
