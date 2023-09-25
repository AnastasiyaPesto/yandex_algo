package ru.zentsova.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {

	private static int calcQuadraticEquation(int a, int x, int b, int c) {
		return (a * (x * x) + b * x + c);
	}

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			List<Integer> values = readList(reader);
			int y = calcQuadraticEquation(values.get(0), values.get(1), values.get(2), values.get(3));
			System.out.println(y);
		}
	}

	private static List<Integer> readList(BufferedReader reader) throws IOException {
		return Arrays.asList(reader.readLine().split(" "))
				.stream()
				.map(elem -> Integer.parseInt(elem))
				.collect(Collectors.toList());
	}
}