package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726 {
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        int N = Integer.parseInt(br.readLine());
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%10007;
        }

            System.out.println(dp[N]);
    }
}
