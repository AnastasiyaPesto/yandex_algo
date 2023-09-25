package ru.zentsova.yandex.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int size = Integer.parseInt(reader.readLine());
			String anySentence = reader.readLine();
			String longestWordInSentence = findLongestWord(anySentence);
			System.out.println(longestWordInSentence);
			System.out.println(longestWordInSentence.length());
		}
	}

	private static String findLongestWord(String sentence) {
		String[] sentenceArray = sentence.split(" ");
		String longestWord = "";
		for (String word : sentenceArray) {
			if (word.trim().length() > longestWord.length())
				longestWord = word.trim();
		}
		return longestWord;
	}
}
