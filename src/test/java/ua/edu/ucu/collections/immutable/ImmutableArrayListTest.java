package ua.edu.ucu.collections.immutable;



import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testEmptyConstructor() {
        ImmutableArrayList array = new ImmutableArrayList();
        assertArrayEquals(new Object[]{}, array.toArray());
        assertEquals(0, array.size());
    }

    @Test
    public void testConstructor() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        Object[] expected = {1, 2, 3};
        assertArrayEquals(expected, array.toArray());
        assertEquals(expected.length, array.size());
    }

    @Test
    public void testAddToEmptyArray() {
        ImmutableArrayList array = new ImmutableArrayList();
        ImmutableArrayList newArray = array.add(1);
        Object[] expectedOld = {};
        Object[] expectedNew = {1};
        assertArrayEquals(expectedOld, array.toArray());
        assertArrayEquals(expectedNew, newArray.toArray());
    }


    @Test
    public void testAdd() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2});
        ImmutableArrayList newArray = array.add(3);
        Object[] expectedOld = {1, 2};
        Object[] expectedNew = {1, 2, 3};
        assertArrayEquals(expectedOld, array.toArray());
        assertArrayEquals(expectedNew, newArray.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexOutOfBounds() {
        ImmutableArrayList array = new ImmutableArrayList();
        array.add(1, 1);
    }

    @Test
    public void testAddByIndex() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        ImmutableArrayList newArray = array.add(1, 9);
        Object[] expectedOld = {1, 2, 3};
        Object[] expectedNew = {1, 9, 2, 3};
        assertArrayEquals(expectedOld, array.toArray());
        assertArrayEquals(expectedNew, newArray.toArray());
    }

    @Test
    public void testAddALl() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        ImmutableArrayList newArray = array.addAll(new Object[]{4, 5});
        Object[] expectedOld = {1, 2, 3};
        Object[] expectedNew = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedOld, array.toArray());
        assertArrayEquals(expectedNew, newArray.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllByIndexOutOfBounds() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2});
        array.addAll(-1, new Object[]{1, 2, 3});
    }

    @Test
    public void testAddAllByIndex() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        ImmutableArrayList newArray = array.addAll(1, new Object[]{9, 9, 9});
        Object[] expectedOld = {1, 2, 3};
        Object[] expectedNew = {1, 9, 9, 9, 2, 3};
        assertArrayEquals(expectedOld, array.toArray());
        assertArrayEquals(expectedNew, newArray.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBounds() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        array.get(3);
    }

    @Test
    public void testGet() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
        Object expected = 5;
        assertEquals(expected, array.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByIndexOutOfBounds() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        array.remove(-1);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        ImmutableArrayList newArray = array.remove(2);
        Object[] expectedOld = {1, 2, 3, 4};
        Object[] expectedNew = {1, 2, 4};
        assertArrayEquals(expectedOld, array.toArray());
        assertArrayEquals(expectedNew, newArray.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetByIndexOutOfBounds() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2});
        array.set(2, 4);
    }

    @Test
    public void testSet() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        ImmutableArrayList newArray = array.set(3, 5);
        Object[] expectedOld = {1, 2, 3, 4};
        Object[] expectedNew = {1, 2, 3, 5};
        assertArrayEquals(expectedOld, array.toArray());
        assertArrayEquals(expectedNew, newArray.toArray());
    }

    @Test
    public void testIndexOfNonExistingItem() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        int expected = -1;
        assertEquals(expected, array.indexOf(4));
    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        int expected = 3;
        assertEquals(expected, array.indexOf(4));
    }

    @Test
    public void testSize() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        int expected = 4;
        assertEquals(expected, array.size());
    }

    @Test
    public void testClear() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        ImmutableArrayList newArray = array.clear();
        Object[] expectedOld = {1, 2, 3};
        Object[] expectedNew = {};
        assertArrayEquals(expectedOld, array.toArray());
        assertArrayEquals(expectedNew, newArray.toArray());
    }

    @Test
    public void testEmptyWhenEmpty() {
        ImmutableArrayList array = new ImmutableArrayList();
        assertTrue(array.isEmpty());
    }

    @Test
    public void testEmptyWhenNonEmpty() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2});
        assertFalse(array.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        Object[] expected = {1, 2, 3};
        assertArrayEquals(expected, array.toArray());
    }

    @Test
    public void testToString() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[]{1, 2, 3});
        String expected = "[1, 2, 3]";
        assertEquals(expected, array.toString());
    }
}
