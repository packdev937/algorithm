package baekjoon.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1799 {

    static int[][] board;
    static boolean[][] visited;
    static int N, maxBlack, maxWhite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, true);   // 검은색 칸에 대한 dfs
        dfs(0, 1, 0, false);  // 흰색 칸에 대한 dfs

        System.out.println(maxBlack + maxWhite);
    }

    public static void dfs(int i, int j, int cnt, boolean isBlack) {
        if (j >= N) {
            i++;
            j = (i % 2 == 0) ? (isBlack ? 0 : 1) : (isBlack ? 1 : 0);
        }

        if (i >= N) {
            if (isBlack) {
                maxBlack = Math.max(maxBlack, cnt);
            } else {
                maxWhite = Math.max(maxWhite, cnt);
            }
            return;
        }

        if (board[i][j] == 1 && canPlaceBishop(i, j)) {
            visited[i][j] = true;
            dfs(i, j + 2, cnt + 1, isBlack);
            visited[i][j] = false;
        }

        dfs(i, j + 2, cnt, isBlack);
    }

    public static boolean canPlaceBishop(int i, int j) {
        if (board[i][j] == 0) {
            return false;
        }
        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board.length; l++) {
                if (Math.abs(k - i) == Math.abs(j - l)) {
                    if (visited[k][l]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
