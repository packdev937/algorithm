package baekjoon.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _14659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int dragon = arr[0];
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < dragon) {
	count++;
            } else {
	dragon = arr[i];
	count = 0;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

}
