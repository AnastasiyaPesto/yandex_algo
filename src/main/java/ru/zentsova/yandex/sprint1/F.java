package ru.zentsova.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.toLowerCase;

public class F {

	private static boolean isPalindrome(String text) {
		int left = 0;
		int right = text.length() - 1;
		while (left < right) {
			if (!isLetterOrDigit(text.charAt(left))) {
				left++;
				continue;
			}

			if (!isLetterOrDigit(text.charAt(right))) {
				right--;
				continue;
			}

			if (!isEqual(text.charAt(left), text.charAt(right)))
				return false;

			left++;
			right--;
		}
		return true;
	}

	private static boolean isEqual(char first, char second) {
		return toLowerCase(first) == toLowerCase(second);
	}

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String text = reader.readLine();
			System.out.println(isPalindrome(text) ? "True" : "False");
		}
	}

}