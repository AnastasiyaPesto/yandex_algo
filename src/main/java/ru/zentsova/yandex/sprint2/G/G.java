package ru.zentsova.yandex.sprint2.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	public int value;
	public Node next;
	public Node prev;

	public Node(int value, Node next, Node prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
}

class StackMaxEffective {

	private Node current;
	private Node maxValues;

	public void push(int value) {
		if (current == null) {
			current = new Node(value, null, null);
			maxValues = new Node(value, null, null);
		} else {
			current = new Node(value, null, current);
			current.prev.next = current;
			maxValues = new Node(Math.max(value, maxValues.value), null, maxValues);
			maxValues.prev.next = maxValues;
		}
	}

	public int pop() {
		if (current == null)
			return Integer.MIN_VALUE;

		int res = current.value;
		current = current.prev;
		maxValues = maxValues.prev;
		return res;
	}

	public int getMax() {
		if (maxValues == null)
			return Integer.MIN_VALUE;
		else
			return maxValues.value;
	}

}

public class G {

	public static void main(String[] args) throws IOException {
		StackMaxEffective stackMax = new StackMaxEffective();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int commandCount = Integer.parseInt(reader.readLine());
		for (int i = 0; i < commandCount; ++i) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String commandName = tokenizer.nextToken();
			int elemIn = Integer.MIN_VALUE;

			if (commandName.equals("push"))
				elemIn = Integer.parseInt(tokenizer.nextToken());

			switch (commandName) {
				case "push":
					stackMax.push(elemIn);
					break;
				case "pop":
					if (stackMax.pop() == Integer.MIN_VALUE)
						System.out.println("error");
					break;
				case "get_max":
					System.out.println(stackMax.getMax() == Integer.MIN_VALUE ? "None" : stackMax.getMax());
					break;
			}
		}
	}
}