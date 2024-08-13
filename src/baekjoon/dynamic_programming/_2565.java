package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2565 {

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int 전깃줄 = 501;

        int[] arr = new int[전깃줄];
        int[] dp = new int[전깃줄];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < dp.length; i++) {
            if (arr[i] == 0) {
	continue;
            }
            for (int j = 0; j < i; j++) {
	if (arr[j] < arr[i]) {
	    dp[i] = Math.max(dp[i], dp[j] + 1);
	    max = Math.max(max, dp[i]);
	}
            }
        }

        System.out.println(N - max);
    }
}