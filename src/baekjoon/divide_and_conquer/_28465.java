package baekjoon.divide_and_conquer;

import java.util.Scanner;

public class _28465 {

    static int[] dp = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        dp[1] = 1;
        dp[2] = 1;
        int idx = 3;
        int bIdx = 0, aIdx = 0;
        while (true) {
            dp[idx] = dp[idx - 1] + dp[idx - 2];
            if (dp[idx] >= a && aIdx == 0) {
                aIdx = idx;
            }
            if (dp[idx] >= b && bIdx == 0) {
                bIdx = idx;
            }
            if (dp[idx] >= Math.max(a, b)) {
                break;
            }
            idx++;
        }

        while (true) {
            if (aIdx == 1 || bIdx == 1) {
                idx = 1;
                break;
            } else {
                if (a <= b) {
                    if (y < dp[bIdx - 2]) {
                        b = dp[bIdx - 2];
                        bIdx -= 2;
                    } else if (dp[bIdx - 2] <= y && y < dp[bIdx] - dp[bIdx - 2]) {
                        idx = bIdx - 1;
                        break;
                    } else {
                        b = dp[bIdx - 2];
                        y -= dp[bIdx - 1];
                        bIdx -= 2;
                    }
                } else if (a > b) {
                    if (x < dp[aIdx - 2]) {
                        a = dp[aIdx - 2];
                        aIdx -= 2;
                    } else if (dp[aIdx - 2] <= x && x < dp[aIdx] - dp[aIdx - 2]) {
                        idx = aIdx - 1;
                        break;
                    } else {
                        a = dp[aIdx - 2];
                        x -= dp[aIdx - 1];
                        aIdx -= 2;
                    }
                }
            }
        }
        System.out.print(idx);
    }
}
