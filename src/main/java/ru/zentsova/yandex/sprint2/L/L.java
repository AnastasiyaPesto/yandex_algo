package ru.zentsova.yandex.sprint2.L;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		int decPowerK = (int) Math.pow(10, k);
		System.out.println(fibonacci(n, decPowerK));
	}

	// Нужно k последних чисел от вычисленного числа Фибонначи
	// Каждое слагаемое остаток от деления на 10^k
	// От суммы также берем остаток от деления на 10^k
	// Примечание. F0 = F1 = 1
	private static int fibonacci(int n, int mod) {
		if (n == 1 || n == 0)
			return 1;

		int prev = 1; int curr = 1;
		for (int i = 2; i <= n; i++) {
			int tmp = prev;
			prev = curr;
			curr = (prev + tmp) % mod;
		}
		return curr;
	}
}