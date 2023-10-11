package ru.zentsova.yandex.sprint3.L;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L {

    private List<Integer> find(List<Integer> arr, int daysCount, int goal) {
        if (arr.isEmpty() || arr.get(daysCount - 1) < goal ) {
            return List.of(-1, -1);
        }

//        int firstDay = binarySearch()
        return Collections.emptyList();
    }

    private static int binarySearch(List<Integer> arr, int x, int left, int right) {
        if (right <= left)
            return -1;

        int mid = (left + right) / 2;
        if (arr.get(mid) == x) {
            return mid;
        } else if (x < arr.get(mid)) {
            return binarySearch(arr, x, 0, mid);
        } else {
            return binarySearch(arr, x, mid + 1, right);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> arr = readList(reader);
            int goal = Integer.parseInt(reader.readLine());
//            printList(binarySearch(arr, goal, 0, n - 1), writer);
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static<T> void printList(List<T> list, Writer writer) {
        list.forEach(elem -> {
                    try {
                        writer.write(String.valueOf(elem));
                        writer.write(" ");
                    } catch (IOException e) {

                    }
                }
        );
    }
}
