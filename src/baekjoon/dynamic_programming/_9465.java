package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9465 {

    static StringTokenizer st;
    final static int INDEX = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[INDEX][N];
            int[][] dp = new int[INDEX][N];
            for (int j = 0; j < INDEX; j++) {
	st = new StringTokenizer(br.readLine());
	for (int k = 0; k < N; k++) {
	    arr[j][k] = Integer.parseInt(st.nextToken());
	}
            }

            // Initialization
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            for (int k = 1; k < N; k++) {
	for (int j = 0; j < INDEX; j++) {
	    int o = j == 0 ? 1 : 0;
	    if (k < 2) {
	        dp[j][k] = dp[o][k - 1] + arr[j][k];
	    } else {
	        dp[j][k] = Math.max(arr[j][k] + dp[o][k - 1], arr[j][k] + Math.max(dp[j][k - 2],dp[o][k-2]));
	    }
	}
            }
            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}
