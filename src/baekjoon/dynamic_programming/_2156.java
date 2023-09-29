package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // Initialization
        dp[0][0] = 0;       // 0번째 포도주를 마시지 않는 경우
        dp[0][1] = arr[0]; // 0번째 포도주를 마시는 경우 (1잔 연속)

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] = dp[i-1][0] + arr[i];
            dp[i][2] = dp[i-1][1] + arr[i];
        }

        System.out.print(Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }
}
