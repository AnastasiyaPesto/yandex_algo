package ru.zentsova.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class B {

	private static String play(int num1, int num2, int num3) {
		if (num1 % 2 == 0)
			return (num2 % 2 == 0 ? (num3 % 2 == 0 ? "WIN" : "FAIL") : "FAIL");
		else
			return (abs(num2 % 2) == 1 ? (abs(num3 % 2) == 1 ? "WIN" : "FAIL") : "FAIL");
	}

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			List<Integer> values = readList(reader);
			System.out.println(play(values.get(0), values.get(1), values.get(2)));
		}
	}

	private static List<Integer> readList(BufferedReader reader) throws IOException {
		return Arrays.asList(reader.readLine().split(" "))
				.stream()
				.map(elem -> Integer.parseInt(elem))
				.collect(Collectors.toList());
	}

}