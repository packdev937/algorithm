package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        // Sort
        Arrays.sort(input);
        int except = (int) Math.round(input.length * 0.15);
        double average = 0;
        for (int i = except; i < input.length - except; i++) {
            average += input[i];
        }
        System.out.println((int) Math.round(average / (input.length - (2 * except))));
    }
}
