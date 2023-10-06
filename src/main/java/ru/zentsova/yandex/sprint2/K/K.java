package ru.zentsova.yandex.sprint2.K;

import java.util.Scanner;

public class K {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(fibonacci(scanner.nextInt()));
    }

    private static int fibonacci(int n) {
        if (n == 1 || n == 0)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}