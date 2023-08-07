package baekjoon.dynamic_programming;

import java.util.Scanner;

public class _10844 {

    static long[][] dp = new long[101][10]; // 2차원 dp 배열로 수정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 길이가 1인 경우, 각 숫자는 계단 수가 될 수 있으므로 1로 초기화
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // dp 배열 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % 1000000000;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        // 길이가 N일 때, 끝자리 숫자가 0부터 9까지의 계단 수의 합 출력
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
            sum %= 1000000000;
        }
        System.out.print(sum);
    }
}
