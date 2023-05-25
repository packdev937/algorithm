package baekjoon.dynamic_programming;

public class _9095 {
    public static void main(String[] args) {

    }
}

// 1,2,3의 합으로 나타내는 법
// dp [2] = 1+1
// dp [3] = 2 // 1 1 1 , 2 1
// dp [4] = dp[N-2] * dp[N-2]  + dp[3] * dp[1]