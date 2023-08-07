package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {

    static int N;
    static int[][] board;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide_conquer(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide_conquer(int sx, int sy, int size) {
        if (isFull(sx, sy, size)) {
            if (board[sx][sy] == 0) {
                white++;
                return;
            } else if (board[sx][sy] == 1) {
                blue++;
                return;
            }
        } else if (!isFull(sx, sy, size)) {
            divide_conquer(sx, sy, size / 2);
            divide_conquer(sx, sy + size / 2, size / 2);
            divide_conquer(sx + size / 2, sy, size / 2);
            divide_conquer(sx + size / 2, sy + size / 2, size / 2);
        }
    }
    public static boolean isFull(int sx, int sy, int size) {
        int color = board[sx][sy];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[sx + i][sy + j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

}
