package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11057 {

    static int[][] dp = new int[1001][10];
    static int divider = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 초기화
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // 동적 프로그래밍
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
	for (int k = 0; k <= j; k++) {
	    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % divider;
	}
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[N][i]) % divider;
        }
        System.out.println(sum);
    }
}
