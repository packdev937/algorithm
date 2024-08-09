package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int mod = 1000000009;

        int maxN = 1000000; // 문제의 제한에 따라 최대 N값을 미리 계산
        long[] dp = new long[maxN + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 모든 경우에 대해 미리 dp 배열을 채운다.
        for (int j = 4; j <= maxN; j++) {
            dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % mod;
        }

        // 테스트 케이스 처리
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
