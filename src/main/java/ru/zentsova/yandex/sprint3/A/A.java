package ru.zentsova.yandex.sprint3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringBuilder outputBuffer = new StringBuilder();
		generateBracketSequence("", 0, 0, n, outputBuffer);
		System.out.println(outputBuffer);
	}

	private static void generateBracketSequence(String str, int open, int close, int n, StringBuilder builder) {
		if (str.length() == 2 * n) {
			builder.append(str).append("\n");
		} else if (open < n) {
			generateBracketSequence(str + "(", open + 1, close, n, builder);
		} if (close < open) {
			generateBracketSequence(str + ")", open, close + 1, n, builder);
		}
	}
}
