package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17404 {

    static int[][] house;
    static int[] dp;
    static final int INF = 99999;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        house = new int[N][3];
        dp = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[j] = house[0][j];
                } else {
                    dp[j] = INF;
                }
            }
            for (int j = 1; j < N; j++) {
                int minDp0 = dp[0];
                int minDp1 = dp[1];
                dp[0] = house[j][0] + Math.min(dp[1], dp[2]);
                dp[1] = house[j][1] + Math.min(dp[2], minDp0);
                dp[2] = house[j][2] + Math.min(minDp1, minDp0);
            }
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    answer = Math.min(answer, dp[j]);
                }
            }
        }
        System.out.println(answer);
    }
}

