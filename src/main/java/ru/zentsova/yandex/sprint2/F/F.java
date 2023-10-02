package ru.zentsova.yandex.sprint2.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class StackMax {

	private final List<Integer> items;
	private Integer maxValue = Integer.MIN_VALUE;

	public StackMax() {
		this.items = new ArrayList<>();
	}

	public void push(Integer elem) {
		if (elem >= maxValue)
			maxValue = elem;

		items.add(elem);
	}

	public Integer pop() {
		if (items.isEmpty())
			return null;

		Integer res = items.remove(items.size() - 1);
		maxValue = Integer.MIN_VALUE;
		for (Integer elem : items) {
			if (elem > maxValue)
				maxValue = elem;
		}

		return res;
	}

	public Integer getMax() {
		return (!items.isEmpty() ? maxValue : null);
	}
}

public class F {

	public static void main(String[] args) throws IOException {
		StackMax stackMax = new StackMax();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int commandCount = Integer.parseInt(reader.readLine());
		for (int i = 0; i < commandCount; ++i) {
			Integer item;
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String commandName = tokenizer.nextToken();
			Integer elem = Integer.MIN_VALUE;
			if (commandName.equals("push"))
				elem = Integer.parseInt(tokenizer.nextToken());
			switch (commandName) {
				case "push":
					stackMax.push(elem);
					break;
				case "pop":
					if (stackMax.pop() == null)
						System.out.println("error");
					break;
				case "get_max":
					item = stackMax.getMax();
					System.out.println(item == null ? "None" : item);
					break;
			}
		}
	}
}
