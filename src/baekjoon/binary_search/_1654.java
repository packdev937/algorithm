package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] inputs = new int[K];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(inputs);

        long max = inputs[inputs.length - 1];
        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {

            mid = (max + min) / 2;

            long count = 0;
            for (int i = 0; i < inputs.length; i++) {
                count += (inputs[i] / mid);
            }
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
