package programmers.lv2;

import java.util.Scanner;

public class 피보나치_수 {
    static int[] dp = new int[100000];

    public int solution(int n) {
        if (dp[n] != 0)
            return dp[n];
        else if (n == 1)
            return 1;
        else if (n == 0)
            return 0;
        else
            return dp[n] = solution(n - 1) + solution(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        피보나치_수 T = new 피보나치_수();
        System.out.println(T.solution(sc.nextInt()));
    }
}
