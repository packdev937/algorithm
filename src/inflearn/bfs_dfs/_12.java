package inflearn.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class _12 {
    private static int[][] board;
    private static int day = -1;
    private static int M, N;
    private static Queue<Point> Q = new LinkedList<>();

    public static void BFS() {
        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Point temp = Q.poll();
                int x = temp.x;
                int y = temp.y;
                if (x > 0 && board[x - 1][y] == 0) {
                    Q.add(new Point(x - 1, y));
                    board[x - 1][y] = 1;
                }
                if (x < N - 1 && board[x + 1][y] == 0) {
                    Q.add(new Point(x + 1, y));
                    board[x + 1][y] = 1;
                }
                if (y > 0 && board[x][y - 1] == 0) {
                    Q.add(new Point(x, y - 1));
                    board[x][y - 1] = 1;
                }
                if (y < M - 1 && board[x][y + 1] == 0) {
                    Q.add(new Point(x, y + 1));
                    board[x][y + 1] = 1;
                }
            }
            day++;
        }
        if (isFull())
            System.out.println(day);
        else System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[N][M];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    Q.add(new Point(i, j));
                }
            }
        }
        BFS();
    }

    public static boolean isFull() {
        boolean isTrue = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0)
                    isTrue = false;
            }
        }
        return isTrue;
    }
}
