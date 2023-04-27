package inflearn.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11 {
    static int[][] board;
    static Queue<Point> Q = new LinkedList<>();
    static int cnt = -1;

    public static void BFS() {
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.println(len);
            if (cnt > 47) {
                cnt = -1;
                break;
            }
            for (int i = 0; i < len; i++) {
                Point temp = Q.poll();
                int x = temp.x;
                int y = temp.y;
                if (x == 6 && y == 6) {
                    Q.clear();
                    break;
                }

                if (x > 0 && board[x - 1][y] == 0) {
                    Q.add(new Point(x - 1, y));
                }
                if (y > 0 && board[x][y - 1] == 0) {
                    Q.add(new Point(x, y - 1));
                }
                if (x < 6 && board[x + 1][y] == 0) {
                    Q.add(new Point(x + 1, y));
                }
                if (y < 6 && board[x][y + 1] == 0) {
                    Q.add(new Point(x, y + 1));
                }
            }
            cnt++;
        }
        System.out.print(cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[7][7];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        Q.add(new Point(0, 0));

        BFS();
    }
}
