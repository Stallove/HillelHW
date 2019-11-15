package HW12Test;

import HW12.StringCollection;

import org.junit.*;

import static org.junit.Assert.*;

public class StringCollectionTest {
    private StringCollection arrTest;
    private StringCollection arrTest2;


    @Before
    public void createArrTest() {
        arrTest = new StringCollection(4);

        arrTest.add("1");
        arrTest.add("2");
        arrTest.add("3");
        arrTest.add("4");
        arrTest.add("5");

        arrTest2 = new StringCollection(4);
        arrTest2.add("1");
        arrTest2.add("2");
        arrTest2.add("3");

    }

    @Test
    public void add() {
        assertTrue(arrTest.add("TestAdd"));
        assertTrue(arrTest.addAll(arrTest2));
    }

    @Test
    public void increaseArr() {
        assertTrue(arrTest.add("4"));
        assertTrue(arrTest.add("TestIncreaseArr"));
        assertTrue(arrTest.add("6"));
    }


    @Test
    public void get() {
        assertEquals("4", arrTest.get(3));
        assertNull(arrTest.get(50));
    }

    @Test
    public void delete() {
        assertTrue(arrTest.delete(3));
        assertTrue(arrTest.delete("3"));
    }

    @Test
    public void contains() {
        assertFalse(arrTest.contains("bbb"));
    }

    @Test
    public void compare() {
        assertFalse(arrTest.equals(arrTest2));

        arrTest2.add("4");
        arrTest2.add("5");

        assertTrue(arrTest.equals(arrTest2));
    }

    @Test
    public void size() {
        assertEquals(5, arrTest.getSize());
    }

    @Test
    public void clear() {
        assertTrue(arrTest.clear());
    }
}
