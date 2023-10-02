package ru.zentsova.yandex.sprint2.H;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Node {
	public Character value;
	public Node next;
	public Node prev;

	public Node(Character value, Node next, Node prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
}

class Stack {
	private Node cur;

	public void push(Character ch) {
		if (cur == null) {
			cur = new Node(ch, null, null);
		} else {
			cur = new Node(ch, null, cur);
			cur.prev.next = cur;
		}
	}

	public Character pop() {
		if (cur == null)
			return null;

		Character ch = cur.value;
		cur = cur.prev;
		return ch;
	}

	public boolean isEmpty() {
		return cur == null;
	}
}

public class H {

	private static final Set<Character> CLOSE_BRACKETS = Set.of('}', ')', ']');
	private static final Map<Character, Character> CLOSE_OPEN_BRACKET_PAIRS = Map.of('}', '{', ')', '(', ']', '[');

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(isCorrectBracketSeq(scanner.nextLine()) ? "True" : "False");
	}

	private static boolean isCorrectBracketSeq(String seq) {
		if (seq == null)
			return false;

		if (seq.isEmpty())
			return true;

		Stack stack = new Stack();
		for (int i = 0; i < seq.length(); i++) {
			char ch = seq.charAt(i);
			if (CLOSE_BRACKETS.contains(ch)) {
				Character openBracket = CLOSE_OPEN_BRACKET_PAIRS.get(ch);
				Character firstCh = stack.pop();
				if (firstCh == null)
					return false;

				if (!openBracket.equals(firstCh))
					return false;
			} else {
				stack.push(ch);
			}
		}

		return stack.isEmpty();
	}
}