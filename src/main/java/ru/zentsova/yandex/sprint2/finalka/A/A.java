package ru.zentsova.yandex.sprint2.finalka.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class DequeueFullSizeException extends RuntimeException { }

class Dequeue {

	private final Integer[] dequeue;
	private final int capacity;
	private int head;
	private int tail;
	private int size;

	public Dequeue(Integer capacity) {
		this.dequeue = new Integer[capacity];
		this.capacity = capacity;
		this.head = 0;
		this.tail = 0;
		this.size = 0;
	}

	public void pushBack(Integer x) {
		if (size == capacity)
			throw new DequeueFullSizeException();

		tail = (tail - 1 + capacity) % capacity;
		dequeue[tail] = x;
		size++;
	}

	public Integer popBack() {
		if (isEmpty()) {
			return null;
		}

		Integer x = dequeue[tail];
		tail = (tail + 1) % capacity;
		dequeue[tail] = null;
		size--;
		return x;
	}

	public void pushFront(Integer x) {
		if (size == capacity)
			throw new DequeueFullSizeException();

		head = (head + 1) % capacity;
		dequeue[head] = x;
		size++;
	}

	public Integer popFront() {
		if (isEmpty()) {
			return null;
		}

		Integer x = dequeue[head];
		head = (head - 1 + capacity) % capacity;
		dequeue[head] = null;
		size--;
		return x;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int commandCount = Integer.parseInt(reader.readLine());
		int dequeueMaxSize = Integer.parseInt(reader.readLine());
		Dequeue dequeue = new Dequeue(dequeueMaxSize);
		for (int i = 0; i < commandCount; ++i) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String commandName = tokenizer.nextToken();
			Integer elem = null;
			if (commandName.equals("push_front") || commandName.equals("push_back"))
				elem = Integer.parseInt(tokenizer.nextToken());
			switch (commandName) {
				case "push_front":
					try {
						dequeue.pushFront(elem);
					} catch (DequeueFullSizeException ex) {
						System.out.println("error");
					}
					break;
				case "push_back":
					try {
						dequeue.pushBack(elem);
					} catch (DequeueFullSizeException ex) {
						System.out.println("error");
					}
					break;
				case "pop_front":
					Integer frontEl = dequeue.popFront();
					System.out.println(frontEl == null ? "error": frontEl);
					break;
				case "pop_back":
					Integer backEl = dequeue.popBack();
					System.out.println(backEl == null ? "error": backEl);
					break;
			}
		}
	}
}