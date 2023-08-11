package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1926 {

    static int[][] board;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int answer = 0;
        int cnt = 0;

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    // 이 부분을 까먹었다
                    board[i][j] = 0;
                    answer = Math.max(bfs(), answer);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(answer);
    }

    public static int bfs() {
        // 간과했던 부분
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length
                    && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    cnt++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }

}
