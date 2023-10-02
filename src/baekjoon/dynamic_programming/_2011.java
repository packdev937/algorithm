package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2011 {

    static int[] dp;
    static int[] fibo = new int[5001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        if (arr[0] == '0') {
            System.out.println(0);
            return;
        }

        dp = new int[arr.length];

        // Fibonacci;
        fibo[0] = 1;
        fibo[1] = 2;
        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            fibo[i]%=1000000;
        }

        dp[0] = 1;
        int continuous = 0;
        int total = 1;
        for (int i = 1; i < arr.length; i++) {
            int num =
                Character.getNumericValue(arr[i - 1]) * 10 + Character.getNumericValue(arr[i]);

            if (num == 0) { // 연속으로 두 번 0이 나오는 경우
                System.out.println(0);
                return;
            }

            if ((num >= 11 && num <= 19) || (num >= 21 && num <= 26)) {
                continuous++;
                dp[i] = (total * fibo[continuous]) % 1000000;
            } else {
                if (num % 10 == 0) {
                    if (num == 10 || num == 20) {
                        if (i > 1) {
                            dp[i - 1] = dp[i - 2];
                        }
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
                total = dp[i - 1];
                continuous = 0;
                dp[i] = (total * fibo[continuous]) % 1000000;
            }
        }
        System.out.println(dp[arr.length - 1]);
    }

}
