package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temperature = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int lp = 0;

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temperature[i];
        }

        int max = sum;
        for (int i = K; i < temperature.length; i++) {
            sum -= temperature[lp++];
            sum += temperature[i];
            max = Math.max(max, sum);
        }

        System.out.print(max);

    }
}
