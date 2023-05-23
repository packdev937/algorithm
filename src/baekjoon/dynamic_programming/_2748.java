package baekjoon.dynamic_programming;

import java.util.Scanner;

public class _2748 {
    static long[] dp;

    public static long fibo(int N) {
        if (dp[N] != 0)
            return dp[N];
        if (N == 0) {
            return dp[N] = 0L;
        }
        if (N == 1 || N == 2) {
            return dp[N] = 1L;
        }
        return dp[N] = fibo(N - 1) + fibo(N - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[N + 1];
        System.out.println(fibo(N));
    }
}
