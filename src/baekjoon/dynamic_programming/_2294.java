package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        int[] dp = new int[K + 1];
        Arrays.fill(dp, 100000); // Large number representing infinity (unreachable state)
        dp[0] = 0; // Base case: zero amount requires zero coins

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int coin : coins) {
            for (int j = coin; j <= K; j++) {
	if (dp[j - coin] != 100000) {
	    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
	}
            }
        }

        if (dp[K] == 100000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}
