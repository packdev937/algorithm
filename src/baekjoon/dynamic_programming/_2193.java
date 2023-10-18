package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2193 {

    static long[] dp;  // int를 long으로 변경

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N];  // int를 long으로 변경
        dp[0] = 1;
        if (N > 1) {  // N이 1보다 큰 경우만 dp[1]에 접근
            dp[1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N - 1]);
    }
}
