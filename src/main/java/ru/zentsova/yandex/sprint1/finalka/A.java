package ru.zentsova.yandex.sprint1.finalka;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://contest.yandex.ru/contest/22450/run-report/91228228/
public class A {

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out)))
		{
			int n = Integer.parseInt(reader.readLine());
			List<Integer> areas = readList(reader);
			printList(getDistances(areas, n), writer);
		}
	}

	private static List<Integer> readList(BufferedReader reader) throws IOException {
		return Arrays.stream(reader.readLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private static<T> void printList(List<T> list, Writer writer) {
		list.forEach(elem -> {
					try {
						writer.write(String.valueOf(elem));
						writer.write(" ");
					} catch (IOException e) {

					}
				}
		);
	}

	private static List<Integer> getDistances(List<Integer> nums, int n) {
		List<Integer> res = new ArrayList<>(n);
		directIteration(res, nums);
		reverseIteration(res, nums);
		return res;
	}

	private static void directIteration(List<Integer> res, List<Integer> nums) {
		int i = 0;
		while (nums.get(i) != 0) {
			res.add(Integer.MAX_VALUE);
			i++;
		}

		int count = 0;
		while (i < nums.size()) {
			if (nums.get(i) == 0) {
				count = 0;
			} else {
				count++;
			}
			res.add(count);
			i++;
		}
	}

	private static void reverseIteration(List<Integer> res, List<Integer> nums) {
		int i = nums.size() - 1;
		while (nums.get(i) != 0) {
			i--;
		}

		int count = 0;
		while (i >= 0) {
			if (nums.get(i) == 0) {
				count = 0;
			} else {
				count++;
			}
			res.set(i, Math.min(res.get(i), count));
			i--;
		}
	}
}