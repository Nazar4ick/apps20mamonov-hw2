package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testQueueConstructor() {
        Queue q = new Queue();
        Object[] expected = new Object[]{};
        assertArrayEquals(expected, q.getItems().toArray());
    }

    @Test
    public void testEnqueue() {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        Object[] expected = {1, 2, 3};
        assertArrayEquals(expected, q.getItems().toArray());
    }

    @Test
    public void testPeek() {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        int expected = 1;
        assertEquals(expected, q.peek());
    }

    @Test
    public void testDequeue() {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        Object[] expected = {2, 3};
        assertArrayEquals(expected, q.getItems().toArray());
    }
}
