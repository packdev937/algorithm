package baekjoon.dynamic_programming;

import java.util.Scanner;

public class _9095 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp = new int[12];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}

// 1,2,3의 합으로 나타내는 법
