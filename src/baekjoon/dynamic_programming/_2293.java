package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2293 {
    static int[] dp;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] coin = new int[N];
        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j <= K; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[K]);
    }
}

