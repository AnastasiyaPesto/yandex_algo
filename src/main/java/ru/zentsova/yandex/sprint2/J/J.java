package ru.zentsova.yandex.sprint2.J;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

class QueueOnList {
    private final LinkedList<Integer> queue = new LinkedList<>();

    public void put(Integer elem) {
        queue.addLast(elem);
    }

    public Integer get() {
        return queue.removeFirst();
    }

    public int size() {
        return queue.size();
    }
}

public class J {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());
        QueueOnList queue = new QueueOnList();
        for (int i = 0; i < commandCount; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            String commandName = token.nextToken();
            Integer elemIn = null;
            if (commandName.equals("put")) {
                elemIn = Integer.parseInt(token.nextToken());
            }

            switch (commandName) {
                case "put":
                    queue.put(elemIn);
                    break;
                case "get":
                    try {
                        System.out.println(queue.get());
                    } catch (NoSuchElementException e) {
                        System.out.println("error");
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
            }
        }
    }
}
