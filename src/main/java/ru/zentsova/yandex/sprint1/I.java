package ru.zentsova.yandex.sprint1;

import java.util.Scanner;

public class I {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean res = isDegree4(scanner.nextInt());
		System.out.println(res ? "True" : "False");
		scanner.close();
	}

	private static boolean isDegree4(int num) {
		if (num == 1 || num == 4)
			return true;

		int curNum = num;
		int reminder;
		do {
			reminder = curNum % 4;
			curNum /= 4;
		} while (reminder == 0 && curNum > 4);
		return reminder == 0 && curNum == 4;
	}
}