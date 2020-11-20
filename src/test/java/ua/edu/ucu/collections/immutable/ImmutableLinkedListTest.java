package ua.edu.ucu.collections.immutable;


import org.junit.Test;
import ua.edu.ucu.collections.node.Node;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testEmptyConstructor() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        Object[] expected = new Object[]{};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testConstructorWithParameter() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        Object[] expected = new Object[]{"aaa"};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        ImmutableLinkedList newList = list.add("bbb");
        Object[] expectedOld = new Object[]{"aaa"};
        Object[] expectedNew = new Object[]{"aaa", "bbb"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexOutOfBounds() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        ImmutableLinkedList newList = list.add("aaa");
        newList = newList.add("bbb");
        newList.add(3, "ccc");
    }

    @Test
    public void testAddByIndex() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        list = list.add("bbb");
        list = list.add("ccc");
        ImmutableLinkedList newList = list.add(2, "ddd");
        Object[] expected = new Object[]{"aaa", "bbb", "ddd", "ccc"};
        assertArrayEquals(expected, newList.toArray());
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        ImmutableLinkedList newList = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        Object[] expectedOld = new Object[]{};
        Object[] expectedNew = new Object[]{"aaa", "bbb", "ccc"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test
    public void testAddAllToNonEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        ImmutableLinkedList newList = list.addAll(new String[]{"bbb", "ccc"});
        Object[] expectedOld = new Object[]{"aaa"};
        Object[] expectedNew = new Object[]{"aaa", "bbb", "ccc"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllByIndexOutOfBounds() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        list.addAll(-1, new String[]{"ddd"});
    }

    @Test
    public void testAddAllByIndex() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        list = list.add("bbb");
        ImmutableLinkedList newList = list.addAll(1, new String[]{"ccc", "ddd"});
        Object[] expectedOld = new Object[]{"aaa", "bbb"};
        Object[] expectedNew = new Object[]{"aaa", "ccc", "ddd", "bbb"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test
    public void testAddAllByZeroIndex() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        list = list.add("bbb");
        ImmutableLinkedList newList = list.addAll(0, new String[]{"ccc", "ddd"});
        Object[] expectedOld = new Object[]{"aaa", "bbb"};
        Object[] expectedNew = new Object[]{"ccc", "ddd", "aaa", "bbb"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBounds() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        list.get(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegativeIndex() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        list.get(-1);
    }

    @Test
    public void testGet() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc", "ddd", "eee"});
        String expected = "ddd";
        assertEquals(expected, list.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBounds() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        list.remove(3);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc", "ddd"});
        ImmutableLinkedList newList = list.remove(2);
        Object[] expectedOld = new Object[]{"aaa", "bbb", "ccc", "ddd"};
        Object[] expectedNew = new Object[]{"aaa", "bbb", "ddd"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test
    public void testRemoveFirstItem() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        ImmutableLinkedList newList = list.remove(0);
        Object[] expectedOld = new Object[]{"aaa", "bbb", "ccc"};
        Object[] expectedNew = new Object[]{"bbb", "ccc"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIndexOutOfBounds() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        list = list.add("bbb");
        list.set(2, "ccc");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetNegative() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        list = list.add("bbb");
        list.set(-3, "ccc");
    }

    @Test
    public void testSetZeroIndex() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        ImmutableLinkedList newList = list.set(0, "bbb");
        Object[] expectedOld = new Object[]{"aaa"};
        Object[] expectedNew = new Object[]{"bbb"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test
    public void testSet() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Node("aaa"));
        list = list.add("bbb");
        ImmutableLinkedList newList = list.set(1, "ccc");
        Object[] expectedOld = new Object[]{"aaa", "bbb"};
        Object[] expectedNew = new Object[]{"aaa", "ccc"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc", "ddd"});
        int expected = 2;
        assertEquals(expected, list.indexOf("ccc"));
    }

    @Test
    public void testIndexOfNonExistingElement() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc", "ddd"});
        int expected = -1;
        assertEquals(expected, list.indexOf("eee"));
    }

    @Test
    public void testSize() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc", "ddd"});
        int expected = 4;
        assertEquals(expected, list.size());
    }

    @Test
    public void testSizeWithEmptyList() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        int expected = 0;
        assertEquals(expected, list.size());
    }

    @Test
    public void testClearWithEmptyList() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.clear();
        Object[] expected = new Object[]{};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testClear() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        ImmutableLinkedList newList = list.clear();
        Object[] expectedOld = new Object[]{"aaa", "bbb", "ccc"};
        Object[] expectedNew = new Object[]{};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testEmptyWhenNotEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb"});
        assertFalse(list.isEmpty());
    }

    @Test
    public void testToArrayWhenEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        Object[] expected = new Object[]{};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        Object[] expected = new Object[]{"aaa", "bbb", "ccc"};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testToString() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        String expected = "[aaa, bbb, ccc]";
        assertEquals(expected, list.toString());
    }

    @Test
    public void testAddFirstWithEmptyList() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        ImmutableLinkedList newList = list.addFirst("aaa");
        assertNull(list.getFirst());
        assertEquals("aaa", newList.getFirst());
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        ImmutableLinkedList newList = list.addFirst("ddd");
        Object[] expectedOld = new Object[]{"aaa", "bbb", "ccc"};
        Object[] expectedNew = new Object[]{"ddd", "aaa", "bbb", "ccc"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test
    public void testAddLastWithEmptyList() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        ImmutableLinkedList newList = list.addLast("aaa");
        assertNull(list.getFirst());
        assertEquals("aaa", newList.getFirst());
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb"});
        ImmutableLinkedList newList = list.addLast("ccc");
        Object[] expectedOld = new Object[]{"aaa", "bbb"};
        Object[] expectedNew = new Object[]{"aaa", "bbb", "ccc"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test
    public void testGetFirst() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        assertEquals("aaa", list.getFirst());
    }

    @Test
    public void testGetLast() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        assertEquals("ccc", list.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstWithEmptyList() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list.removeFirst();
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        ImmutableLinkedList newList = list.removeFirst();
        Object[] expectedOld = new Object[]{"aaa", "bbb", "ccc"};
        Object[] expectedNew = new Object[]{"bbb", "ccc"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLastWithEmptyList() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list.removeLast();
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new String[]{"aaa", "bbb", "ccc"});
        ImmutableLinkedList newList = list.removeLast();
        Object[] expectedOld = new Object[]{"aaa", "bbb", "ccc"};
        Object[] expectedNew = new Object[]{"aaa", "bbb"};
        assertArrayEquals(expectedOld, list.toArray());
        assertArrayEquals(expectedNew, newList.toArray());
    }
}
