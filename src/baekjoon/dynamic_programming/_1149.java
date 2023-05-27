package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1149 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] sArr = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(sArr[j]);
            }
        }

        // Initialization
        dp[0][0] = board[0][0];
        dp[0][1] = board[0][1];
        dp[0][2] = board[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = board[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = board[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = board[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }

        System.out.println(Math.min(dp[N - 1][2], (Math.min(dp[N - 1][0], dp[N - 1][1]))));
    }
}
