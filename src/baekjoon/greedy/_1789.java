package baekjoon.greedy;

import java.util.Scanner;

public class _1789 {

    static long[] dp = new long[100000];

    public static void main(String[] args) {
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1] + i;
        }

        long N = new Scanner(System.in).nextLong();
        int index = 1;
        while (N > dp[index]) {
            index++;
        }
        if (N == dp[index]) {
            System.out.print(index);
        } else {
            System.out.print(index - 1);
        }
    }
}
