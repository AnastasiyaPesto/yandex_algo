package ru.zentsova.yandex.sprint1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class H {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();
        System.out.println(addTwoBinaryNums(num1, num2));
        scanner.close();
    }

    private static String addTwoBinaryNums(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        String curComb = "";
        String tmp = "0";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            curComb = Character.toString(num1.charAt(i)) + Character.toString(num2.charAt(j));
            switch (curComb) {
                case "00":
                    if (tmp.equals("1")) {
                        res.append("1");
                        tmp = "0";
                    } else {
                        res.append("0");
                    }
                    break;
                case "10":
                case "01":
                    if (tmp.equals("1")) {
                        res.append("0");
                    } else {
                        res.append("1");
                    }
                    break;
                case "11":
                    if (tmp.equals("1")) {
                        res.append("1");
                    } else {
                        res.append("0");
                        tmp = "1";
                    }
                    break;
                default:
                    throw new NoSuchElementException("The operation is not supported");
            }
            i--;
            j--;
        }

        if (i == j && tmp.equals("1")) {
            res.append(tmp);
            return res.reverse().toString();
        }

        while (i >= 0) {
            if (tmp.equals("1")) {
                if (num1.charAt(i) == '1')
                    res.append("0");
                else {
                    res.append("1");
                    tmp = "0";
                }
            } else {
                res.append(num1.charAt(i));
            }
            i--;
        }

        while (j >= 0) {
            if (tmp.equals("1")) {
                if (num2.charAt(j) == '1')
                    res.append("0");
                else {
                    res.append("1");
                    tmp = "0";
                }
            } else {
                res.append(num2.charAt(j));
            }
            j--;
        }
        return res.append(tmp.equals("1") ? tmp : "").reverse().toString();
    }
}