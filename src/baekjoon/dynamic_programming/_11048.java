package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11048 {

    static int[] dy = {1, 1, 0};
    static int[] dx = {0, 1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < board[i].length; j++) {
	board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
	dp[i][j] =
	    board[i][j] + Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        System.out.println(dp[N][M]);
    }

}
