package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열 A의 크기
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int max = 1;

        // 수열 A 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            A[index++] = Integer.parseInt(st.nextToken());
        }

        // Initiation
        Arrays.fill(dp, 1);

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
	if (A[i] < A[j]) {
	    dp[i] = Math.max(dp[i], dp[j] + 1);
	    max = Math.max(max, dp[i]);
	}
            }
        }

        System.out.println(max);
    }

}
