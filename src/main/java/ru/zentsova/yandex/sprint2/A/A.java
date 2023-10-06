package ru.zentsova.yandex.sprint2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException {
		StringBuilder outputBuffer = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int colCnt = Integer.parseInt(reader.readLine());
		int rowCnt = Integer.parseInt(reader.readLine());
		int[][] res = new int[rowCnt][colCnt];
		for (int i = 0; i < colCnt; i++) {
			StringTokenizer line = new StringTokenizer(reader.readLine());
			int row = 0;
			while (row < rowCnt) {
				int num = Integer.parseInt(line.nextToken());
				res[row++][i] = num;
			}
		}
		for (int i = 0; i < rowCnt; i++) {
			for (int j = 0; j < res[i].length; j++) {
				outputBuffer.append(res[i][j]).append(" ");
			}
			outputBuffer.append("\n");
		}
		System.out.println(outputBuffer);
	}
}
