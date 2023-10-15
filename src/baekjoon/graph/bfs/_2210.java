package baekjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2210 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] board;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                dfs(i, j, 1, String.valueOf(board[i][j]));
            }
        }

        System.out.println(set.size());
    }

    public static void dfs(int y, int x, int depth, String answer) {
        if (depth == 6) {
            set.add(answer);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length) {
                dfs(ny, nx, depth + 1, answer + board[ny][nx]);
            }
        }
    }

}