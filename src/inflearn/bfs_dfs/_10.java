package inflearn.bfs_dfs;

import java.util.Scanner;

public class _10 {
    static int[][] board;
    static int cnt = 0;

    public static void DFS(int x, int y) {
        if (x > 0 && board[x - 1][y] == 0) {
            board[x][y] = 1;
            DFS(x - 1, y);
            board[x][y] = 0;
        }
        if (y > 0 && board[x][y - 1] == 0) {
            board[x][y] = 1;
            DFS(x, y - 1);
            board[x][y] = 0;
        }
        if (x < 6 && board[x + 1][y] == 0) {
            board[x][y] = 1;
            DFS(x + 1, y);
            board[x][y] = 0;
        }
        if (y < 6 && board[x][y + 1] == 0) {
            board[x][y] = 1;
            DFS(x, y + 1);
            board[x][y] = 0;
        }
        if (x == 6 && y == 6) {
            cnt++;
            return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[7][7];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        DFS(0, 0);
        System.out.print(cnt);
    }
}
