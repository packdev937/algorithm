package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
	if (arr[i] > arr[j]) {
	    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
	}
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(i, max);
        }

        System.out.println(max);
    }
}
