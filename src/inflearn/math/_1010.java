package inflearn.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1010 {
    static long[][] dp = new long[31][31];

    public static long combination(int n, int r) {
        if (dp[n][r] != 0) return dp[n][r];
        if (r == 0 || n == r) return dp[n][r] = 1;
        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            long result = combination(M, N);
            System.out.println(result);
        }
    }
}
