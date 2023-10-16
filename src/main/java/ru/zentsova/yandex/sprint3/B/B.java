package ru.zentsova.yandex.sprint3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class B {

	private static final Map<Character, String> DICT =
			Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

	private static void generateCombination(String numbers, int i, String currentWord, StringBuilder accum) {
		if (i == numbers.length()) {
			accum.append(currentWord).append(" ");
			return;
		}

		String btnStr = DICT.get(numbers.charAt(i));
		for (int j = 0; j < btnStr.length(); j++) {
			generateCombination(numbers, i + 1, currentWord + btnStr.charAt(j), accum);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String numbers = reader.readLine();

		if (numbers.length() == 1)
			System.out.println(DICT.get(numbers.charAt(0)));

		StringBuilder outputBuffer = new StringBuilder();
		generateCombination(numbers, 0, "", outputBuffer);
		System.out.println(outputBuffer);
	}
}
