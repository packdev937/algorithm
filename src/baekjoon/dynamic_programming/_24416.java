package baekjoon.dynamic_programming;

import java.util.Scanner;

public class _24416 {
    static int oriCnt;
    static int cnt;

    static int[] dp;

    public static int fibo_dp(int N) {
        if (dp[N] != 0)
            return dp[N];
        else if (N == 1 || N == 2) {
            return 1;
        } else {
            cnt++;
            return dp[N] = fibo_dp(N - 1) + fibo_dp(N - 2);
        }
    }

    public static int fibo(int N) {
        if (N == 1 || N == 2) {
            oriCnt++;
            return 1;
        } else return fibo(N - 1) + fibo(N - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        // Initialization
        dp = new int[N + 1];
        fibo(N);
        fibo_dp(N);

        sb.append(oriCnt).append(" ").append(cnt);
        System.out.println(sb);
    }
}
