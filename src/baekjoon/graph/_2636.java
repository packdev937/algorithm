package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2636 {
    static int[][] board;
    static boolean[][] ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static final int air = 99999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        board = new int[N][M];
        ch = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int hr = 0;
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        while (true) {
            hr++;
            if (isBoardEmpty())
                break;
            makeAir();
            cnt = 0;
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    boolean isTrue = false;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (nx < board[0].length && ny < board.length && board[ny][nx] == air && board[i][j] == 1) {
                            isTrue = true;
                            break;
                        }
                    }
                    if (isTrue && !ch[i][j]) {
                        board[i][j] = air;
                        q.add(new int[]{i, j});
                        ch[i][j] = true;
                    }
                }
            }
            System.out.println(q.size());

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                board[temp[0]][temp[1]] = air;
                cnt++;
            }
        }
        System.out.println(hr);
        System.out.println(cnt);
    }

    public static void makeAir() {
        // left
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    break;
                }
                board[i][j] = air;
            }
        }

        // right
        for (int i = 0; i < board.length; i++) {
            for (int j = board[i].length - 1; j >= board[i].length; j--) {
                if (board[i][j] == 1)
                    break;
                board[i][j] = air;
            }
        }

        // up
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 1)
                    break;
                board[j][i] = air;
            }
        }

        // down
        for (int i = 0; i < board[0].length; i++) {
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] == 1)
                    break;
                board[j][i] = air;
            }
        }
    }

    public static boolean isBoardEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0 || board[i][j] != air) {
                    isEmpty = false;
                    break;
                }
            }
        }
        return isEmpty;
    }
}
