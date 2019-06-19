package Lesson3.queue;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueImplTest {

    @Test
    public void insert() {
        Queue<Integer> queue = new PriorityQueue<>(4);
        Assert.assertEquals(queue.insert(3), false);

    }

    @Test
    public void remove() {
        Queue<Integer> queue = new PriorityQueue<>(4);
        Assert.assertNull(queue.remove());
    }

    @Test
    public void peek() {
        Queue<Integer> queue = new PriorityQueue<>(4);
        int tmp1 = 4;
        queue.insert(tmp1);
        int tmp = queue.peek();
        Assert.assertEquals(tmp1, tmp);
    }

    @Test
    public void isEmpty() {
        Queue<Integer> queue = new PriorityQueue<>(4);
        Assert.assertEquals(queue.isEmpty(), true);
    }

    @Test
    public void isFull() {
        Queue<Integer> queue = new PriorityQueue<>(4);
        Assert.assertEquals(queue.isFull(), false);
    }
}