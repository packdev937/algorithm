package programmers.lv2;
public class 정수_삼각형 {
    class Solution {

        public int solution(int[][] triangle) {
            int [][] dp = new int [triangle.length][triangle.length];

            // Initialize
            dp[0][0] = triangle[0][0];

            for (int i = 1; i < triangle.length; i++) {
	// 맨 왼쪽
	dp[i][0] = dp[i - 1][0] + triangle[i][0];

	// 중간 부분
	for (int j = 1; j < triangle[i].length - 1; j++) {
	    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
	}

	// 맨 오른쪽
	dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            }


            int answer = 0;
            for(int i = 0; i<dp.length; i++) {
	answer = Math.max(answer, dp[dp.length-1][i]);
            }

            return answer;
        }
    }

}
