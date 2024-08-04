package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] cards = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j >= 0; j--) {
	dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
            }
        }

        System.out.println(dp[N]);
    }

}
