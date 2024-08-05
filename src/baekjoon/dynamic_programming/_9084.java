package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Test Case
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // Initialization
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
	coins[j] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target + 1];

            dp[0] = 1; // Base case: 0원을 만드는 방법은 1가지

            for (int coin : coins) {
	for (int j = coin; j <= target; j++) {
	    dp[j] += dp[j - coin];
	}
            }

            System.out.println(dp[target]);
        }
    }
}
