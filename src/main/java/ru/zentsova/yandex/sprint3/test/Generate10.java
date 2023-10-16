package ru.zentsova.yandex.sprint3.test;

public class Generate10 {
	public static void main(String[] args) {
		genBinary(2, "");
	}

	static void genBinary(int n, String prefix) {
		if (n == 0) {
			System.out.println(prefix);
		} else {
			genBinary(n - 1, prefix + "0");
			genBinary(n - 1, prefix + "1");
		}
	}
}
