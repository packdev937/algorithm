package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1012 {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static Queue<int[]> queue;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] board = new int[M][N];
            cnt = 0;
            queue = new LinkedList<>();
            for (int j = 0; j < K; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                board[a][b] = 1;
            }

            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[0].length; k++) {
                    if (board[j][k] == 1) {
                        queue.add(new int[]{j, k});
                        bfs(board);
                        cnt++;
                    }
                }

            }
            System.out.println(cnt);
        }
    }

    public static void bfs(int[][] board) {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (board[temp[0]][temp[1]] != 1) {
                continue;
            }
            board[temp[0]][temp[1]] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if (nx >= 0
                    && nx < board.length
                    && ny >= 0
                    && ny < board[0].length
                    && board[nx][ny] == 1
                ) {
                    queue.add(new int[]{nx, ny});

                }
            }
        }
    }
}