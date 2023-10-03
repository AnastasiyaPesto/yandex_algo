package ru.zentsova.yandex.sprint2.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class QueueFullSizeException extends RuntimeException {
}

class MyQueueSized {

    private final Integer[] queue;
    private final int max;
    private int head;
    private int tail;
    private int size;

    public int getSize() {
        return size;
    }

    public MyQueueSized(Integer maxSize) {
        this.queue = new Integer[maxSize];
        this.max = maxSize;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void push(Integer x) {
        if (size == max)
            throw new QueueFullSizeException();

        queue[tail] = x;
        tail = (tail + 1) % max;
        size++;
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

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }

        return queue[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

}

public class I {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());
        int queueSize = Integer.parseInt(reader.readLine());
        MyQueueSized queue = new MyQueueSized(queueSize);
        for (int i = 0; i < commandCount; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            String commandName = token.nextToken();
            Integer elemIn = null;
            if (commandName.equals("push")) {
                elemIn = Integer.parseInt(token.nextToken());
            }

            switch (commandName) {
                case "push":
                    try {
                        queue.push(elemIn);
                    } catch (QueueFullSizeException ex) {
                        System.out.println("error");
                    }
                    break;
                case "pop":
                    Integer firstEl = queue.pop();
                    System.out.println(firstEl == null ? "None" : firstEl);
                    break;
                case "peek":
                    System.out.println(queue.peek() == null ? "None" : queue.peek());
                    break;
                case "size":
                    System.out.println(queue.getSize());
                    break;
            }
        }
    }

}
