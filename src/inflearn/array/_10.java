package inflearn.array;

import java.util.Scanner;

public class _10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N + 2][N + 2];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i + 1][j + 1] = sc.nextInt();
            }
        }

        // check vertex
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int vertex = board[i + 1][j + 1];
                if (vertex > board[i + 1][j] && vertex > board[i][j + 1] && vertex > board[i + 1][j + 2] && vertex > board[i + 2][j + 1])
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
