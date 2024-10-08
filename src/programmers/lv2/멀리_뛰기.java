package programmers.lv2;

public class 멀리_뛰기 {

    class Solution {

        long[] dp = new long[2001];

        public long solution(int n) {
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
	dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }

            return dp[n];
        }
    }
}
