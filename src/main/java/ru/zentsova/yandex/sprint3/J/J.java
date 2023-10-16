package ru.zentsova.yandex.sprint3.J;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class J {

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
			int n = Integer.parseInt(reader.readLine());
			List<Integer> array = readList(reader);
			bubbleSort(array, n, writer);
		}
	}

	private static List<Integer> readList(BufferedReader reader) throws IOException {
		return Arrays.stream(reader.readLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private static<T> void printList(List<T> list, Writer writer) {
		try {
			for (T elem : list) {
				writer.write(String.valueOf(elem));
				writer.write(" ");
			}
			writer.write("\n");
		} catch (IOException e) {

		}
	}

	public static void bubbleSort(List<Integer> array, int n, BufferedWriter writer) {
		for (int i = array.size() - 1; i >= 0; i--) {
			boolean isChanged = false;
			int j = 0;
			while (j < i) {
				if (array.get(j) > array.get(j + 1)) {
					swap(array, j, j + 1);
					isChanged = true;
				}
				j++;
			}
			if (isChanged) {
				printList(array, writer);
			}
		}
	}

	private static void swap(List<Integer> array, int i, int j) {
		int tmp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, tmp);
	}
}