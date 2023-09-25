package ru.zentsova.yandex.sprint1;

import java.util.Scanner;

public class G {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int decimal = scanner.nextInt();
		String binary = convertDecimalToBinary(decimal);
		System.out.println(binary);
	}

	private static String convertDecimalToBinary(int number) {
		StringBuilder builder = new StringBuilder();
		int cur = number;
		while (cur > 1) {
			builder.append(cur % 2);
			cur /= 2;
		}
		builder.append(cur);
		return builder.reverse().toString();
	}
}