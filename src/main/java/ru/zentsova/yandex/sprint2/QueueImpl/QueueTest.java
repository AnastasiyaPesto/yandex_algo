package ru.zentsova.yandex.sprint2.QueueImpl;

import java.util.Arrays;

class Queue {

    private Integer[] queue;
    private final int max;
    private int head;
    private int tail;
    private int size;

    public Integer[] getQueue() {
        return queue;
    }

    public Queue(Integer n) {
        this.queue = new Integer[n];
        this.max = n;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void push(Integer x) {
        if (size != max) {
            queue[tail] = x;
            tail = (tail + 1) % max;
            size++;
        }
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }

        Integer x = queue[head];
        queue[head] = null;
        head = (head + 1) % max;
        size--;
        return x;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}

public class QueueTest {

    public static void main(String[] args) {
        Queue queue = new Queue(8);

        queue.pop();
        System.out.println(Arrays.toString(queue.getQueue()));
    }

}
