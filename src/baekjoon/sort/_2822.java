package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _2822 {

    private static int INPUT_CRITERION = 8;
    private static int SUM_CRITERION = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer[]> score = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });

        for (int i = 0; i < INPUT_CRITERION; i++) {
            score.add(new Integer[]{Integer.parseInt(br.readLine()), i + 1});
        }

        int[] index = new int[SUM_CRITERION];
        int sum = 0;
        for (int i = 0; i < SUM_CRITERION; i++) {
            sum += score.peek()[0];
            index[i] = score.poll()[1];
        }

        System.out.println(sum);
        Arrays.sort(index);
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i] + " ");
        }
    }
}
