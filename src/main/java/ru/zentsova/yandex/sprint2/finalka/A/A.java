package ru.zentsova.yandex.sprint2.finalka.A;

/*
-- Спринт 2. Финалка. А. Дек --
Ссылка на удачную посылку: https://contest.yandex.ru/contest/22781/run-report/92394946/

-- ПРИНЦИП РАБОТЫ --
- добавить в начало: добавить элемент -> сдвинуть head по часовой стрелке
- добавить в конец: сдвинуть tail против часовой стрелки -> добавить элемент
- извлечь с начала: сдвинуть head против часовой стрелки -> извлечь элемент -> присвоить dequeue[head] = null
- извлечь с конца: извлечь элемент -> присвоить dequeue[tail] = null -> сдвинуть tail по часовой стрелки

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Так как дек поддерживает операции вставки и в конце и в начало, а также извлечение из конца и из начала очереди, то можно
сдвигать head и tail в любую сторону, главное выбрать один подход и придерживаться ему в течении всего решения.

По поводу вычисления индекса, когда сдвиг против часовой стрелки:
Чтобы не получалось ситуации, когда head (tail) будeт равeн -1, необходимо перед взятием остатка от деления по модулю
прибавить к head (tail) максимальный размер (capacity)
 */

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
		dequeue[tail] = null;
		tail = (tail + 1) % capacity;
		size--;
		return x;
	}

	public void pushFront(Integer x) {
		if (size == capacity)
			throw new DequeueFullSizeException();

		dequeue[head] = x;
		head = (head + 1) % capacity;
		size++;
	}

	public Integer popFront() {
		if (isEmpty()) {
			return null;
		}

		head = (head - 1 + capacity) % capacity;
		Integer x = dequeue[head];
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
		StringBuilder outputBuffer = new StringBuilder();
		for (int i = 0; i < commandCount; ++i) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String commandName = tokenizer.nextToken();
			Integer elem = null;
			if (commandName.equals("push_front") || commandName.equals("push_back"))
				elem = Integer.parseInt(tokenizer.nextToken());
			switch (commandName) {
				case "push_front":
					pushFront(dequeue, elem, outputBuffer);
					break;
				case "push_back":
					pushBack(dequeue, elem, outputBuffer);
					break;
				case "pop_front":
					popFront(dequeue, outputBuffer);
					break;
				case "pop_back":
					popBack(dequeue, outputBuffer);
					break;
			}
		}
		System.out.println(outputBuffer);
	}

	private static void pushFront(Dequeue dequeue, Integer elem, StringBuilder outputBuffer) {
		try {
			dequeue.pushFront(elem);
		} catch (DequeueFullSizeException ex) {
			outputBuffer.append("error").append("\n");
		}
	}

	private static void pushBack(Dequeue dequeue, Integer elem, StringBuilder outputBuffer) {
		try {
			dequeue.pushBack(elem);
		} catch (DequeueFullSizeException ex) {
			outputBuffer.append("error").append("\n");
		}
	}

	private static void popFront(Dequeue dequeue, StringBuilder outputBuffer) {
		Integer frontEl = dequeue.popFront();
		outputBuffer.append(frontEl == null ? "error": frontEl).append("\n");
	}

	private static void popBack(Dequeue dequeue, StringBuilder outputBuffer) {
		Integer backEl = dequeue.popBack();
		outputBuffer.append(backEl == null ? "error": backEl).append("\n");
	}
}