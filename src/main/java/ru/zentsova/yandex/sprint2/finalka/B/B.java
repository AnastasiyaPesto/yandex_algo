package ru.zentsova.yandex.sprint2.finalka.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Stack {

    private final List<String> items = new ArrayList<>();

    public void push(String elem) {
        items.add(elem);
    }

    public String pop() {
        return items.isEmpty() ? null : items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer task = new StringTokenizer(reader.readLine());
        Stack stack = new Stack();
        while (task.hasMoreElements()) {
            char curr = task.nextToken().charAt(0);
            if (Character.isDigit(curr)) {
                stack.push(String.valueOf(curr));
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result;
                switch (curr) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
                stack.push(String.valueOf(result));
            }
        }
        System.out.println(stack.pop());
    }
}
