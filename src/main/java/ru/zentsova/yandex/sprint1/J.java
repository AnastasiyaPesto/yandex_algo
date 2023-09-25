package ru.zentsova.yandex.sprint1;

import java.util.Scanner;

public class J {

	// Факторизация числа - не решено
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		String integerFactorization = simpleMultipliers(number);
		System.out.println(integerFactorization);
		scanner.close();
	}

	private static String simpleMultipliers(int num) {
		if (num == 0 || num == 1)
			return String.valueOf(num);

		StringBuilder result = new StringBuilder();
		int curNum = num;
		int curPrimeNum = 2;
		while (curNum != 1) {
			if (curNum % curPrimeNum == 0) {
				curNum = curNum / curPrimeNum;
				result.append(curPrimeNum).append(" ");
			} else {
				curPrimeNum = getNextPrimeNumber(curPrimeNum);
			}
		}
		return result.deleteCharAt(result.length() - 1).toString();
	}

	private static int getNextPrimeNumber(int num) {
		int cur = num + 1;
		while (!isPrime(cur)) {
			cur++;
		}
		return cur;
	}

	private static boolean isPrime(int number) {
		if(number < 2)
			return false;
		for(int i = 2; i <= number / 2; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

}