package inflearn.bfs_dfs;

import java.util.Scanner;

public class _10 {
    static int[][] board, ch;
    static int cnt;

    public static void dfs(int x, int y) {
        if (x == 6 && y == 6) {
            cnt++;
        } else if (x != 6 && board[x + 1][y] != 1) {
            board[x][y] = 1;
            dfs(x + 1, y);
            board[x][y] = 0;
        } else if (y != 6 && board[x][y + 1] != 1) {
            board[x][y] = 1;
            dfs(x, y + 1);
            board[x][y] = 0;
        } else if (x != 0 && board[x - 1][y] != 1) {
            board[x][y] = 1;
            dfs(x - 1, y);
            board[x][y] = 0;
        } else if (y != 0 && board[x][y - 1] != 1) {
            board[x][y] = 1;
            dfs(x, y - 1);
            board[x][y] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[7][7];
        ch = new int [7][7];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.print(cnt);
    }
}
