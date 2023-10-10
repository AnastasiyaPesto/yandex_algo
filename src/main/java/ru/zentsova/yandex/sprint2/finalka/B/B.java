package ru.zentsova.yandex.sprint2.finalka.B;

/*
-- Спринт 2. Финалка. А. Калькулятор --
Ссылка на удачную посылку: https://contest.yandex.ru/contest/22781/run-report/92517402/

-- ПРИНЦИП РАБОТЫ --
Сам алгоритм описан максимально подробно, поэтому не знаю что здесь писать. Такой задачи ранее
Об этой задаче ранее я слышала, но никогда не сталкивалась и не реализовывала. Но помню, что решается через стек.
Поэтому, если бы не был бы приведен алгоритм, я бы попробовала решать также через стек.

Про деление. В Java целочисленное деление реализовано несколько иначе, чем требует математика.
Поэтому реализовала простенький метод для такого деления. Так как в текущей задаче гарантируется,
что деления на отрицательное число нет, то рассмотрела только случай, когда делимое < 0 и округляю результат вниз.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Стек работает по принципу LIFO. Сложность алгоритма O(n), потому что мы обрабатываем каждую позицию в строке (кроме пробелов).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
O(n):
O(n) - хранение входящей строки
O(n/2) - примерно столько понадобиться для хранения операндов (знаки операции в стек не кладутся)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

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
    private static Pattern NUMERIC_REGEX = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer task = new StringTokenizer(reader.readLine());
        Stack stack = new Stack();
        while (task.hasMoreElements()) {
            String curr = task.nextToken();
            if (isNumeric(curr)) {
                stack.push(curr);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result;
                switch (curr) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = div(num2, num1);
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
                stack.push(String.valueOf(result));
            }
        }
        System.out.println(stack.pop());
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return NUMERIC_REGEX.matcher(strNum).matches();
    }

    private static int div(int a, int b) {
        if (a < 0)
            return Math.floorDiv(a, b);
        return a / b;
    }
}