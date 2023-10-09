package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589 {

    static char[][] board;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, M
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(max - 1);
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 0});
        boolean[][] visited = new boolean[N][M];

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (visited[temp[0]][temp[1]]) {
                continue;
            }
            visited[temp[0]][temp[1]] = true;
            for (int k = 0; k < 4; k++) {
                int ny = temp[0] + dy[k];
                int nx = temp[1] + dx[k];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && board[ny][nx] == 'L') {
                    max = Math.max(max, temp[2] + 1);
                    queue.add(new int[]{ny, nx, temp[2] + 1});
                }
            }
        }
    }

}
