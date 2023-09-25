package ru.zentsova.yandex.sprint1;

public class AlgorithmSpeed {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		int i = 0;
		while (i < 1_000_000) {
			++i;
		}

		long endTime = System.currentTimeMillis();

		double timeElapsedSec = (System.currentTimeMillis() - startTime) / (double) 1000;
		long timeElapsedMillis = System.currentTimeMillis() - startTime;

		System.out.println(timeElapsedSec + " seconds");
		System.out.println(timeElapsedMillis + " milliseconds");
	}

}