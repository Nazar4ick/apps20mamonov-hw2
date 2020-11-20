package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testConstructor() {
        Stack s = new Stack();
        Object[] expected = new Object[]{};
        assertArrayEquals(expected, s.getItems().toArray());
    }

    @Test
    public void testPush() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        Object[] expected = {1, 2, 3};
        assertArrayEquals(expected, s.getItems().toArray());
    }

    @Test
    public void testPeek() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        int expected = 3;
        assertEquals(expected, s.peek());
    }

    @Test
    public void testPop() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        Object[] expected = {1, 2};
        assertArrayEquals(expected, s.getItems().toArray());
    }
}
