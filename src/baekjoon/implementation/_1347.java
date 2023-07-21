package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1347 {
    static char[] status = {'S', 'W', 'N', 'E'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] inputs = br.readLine().toCharArray();
        char[][] board = new char[101][101]; // make it 101 to prevent ArrayIndexOutOfBoundsException
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                board[i][j] = '#';
            }
        }
        int x = 50, y = 50;
        int maX = x, miX = x, maY = y, miY = y; // update initial maximum and minimum values
        board[x][y] = '.';
        int idx = 0;
        for (int i = 0; i < N; i++) {
            char opt = inputs[i];
            if (opt == 'R') {
                idx = idx + 1 > 3 ? 0 : idx + 1;
            } else if (opt == 'L') {
                idx = idx - 1 < 0 ? 3 : idx - 1;
            } else if (opt == 'F') {
                switch (status[idx]) {
                    case 'S':
                        board[++x][y] = '.';
                        maX = Math.max(maX, x);
                        break;
                    case 'W':
                        board[x][--y] = '.';
                        miY = Math.min(miY, y);
                        break;
                    case 'N':
                        board[--x][y] = '.';
                        miX = Math.min(miX, x);
                        break;
                    case 'E':
                        board[x][++y] = '.';
                        maY = Math.max(maY, y);
                        break;
                }
            }
        }
        for (int i = miX; i <= maX; i++) {
            for (int j = miY; j <= maY; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
