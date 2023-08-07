package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14940 {

    static int[][] board;
    static int[][] answer;
    static boolean[][] ch;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        answer = new int[N][M];
        ch = new boolean[N][M];
        int sx = 0, sy = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }
        bfs(sx, sy);
        answer[sx][sy] = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && answer[i][j] == 0) {
                    answer[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int sx, int sy) {
        queue.add(new int[]{sx, sy});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            if (ch[temp[0]][temp[1]]) {
                continue;
            } else {
                ch[temp[0]][temp[1]] = true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + temp[0];
                int ny = dy[i] + temp[1];
                if (nx > -1 && nx < board.length && ny > -1 && ny < board[0].length
                    && board[nx][ny] == 1 && !ch[nx][ny]) {
                    answer[nx][ny] = answer[temp[0]][temp[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

}
