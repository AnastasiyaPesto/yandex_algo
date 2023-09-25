package ru.zentsova.yandex.sprint1.finalka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://contest.yandex.ru/contest/22450/run-report/91236291/
public class B {

	private static final int MAX_NUM_VALUE_FIELD = 9;

	public static void main(String[] args) throws IOException {
		StringBuilder field = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(reader.readLine());;
		for (int i = 0; i < 4; i++) {
			field.append(reader.readLine());
		}
		int[] preparedField = processField(field.toString());
		int res = getMaxPointInPlay(preparedField, k);
		System.out.println(res);
	}

	private static int[] processField(String field) {
		int[] res = new int[MAX_NUM_VALUE_FIELD + 1];
		for (int i = 0; i < field.length(); i++) {
			if (Character.isDigit(field.charAt(i))) {
				res[Character.getNumericValue(field.charAt(i))]++;
			}
		}
		return res;
	}

	private static int getMaxPointInPlay(int[] field, int k) {
		int maxPressedKeyCnt = 2 * k;
		int maxPoint = 0;
		for (int num : field) {
			if (num != 0 && maxPressedKeyCnt >= num) {
				maxPoint++;
			}
		}
		return maxPoint;
	}
}