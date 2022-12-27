package baekjoon.implementation;

import java.util.Scanner;

public class _2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[100][100];
        int x, y, cnt = 0, minX = 999, minY = 999, maxX = 0, maxY = 0;

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    board[j][k] = 1;
                }
            }
            if (x < minX) minX = x;
            if (y < minY) minY = y;
            if (x + 10 > maxX) maxX = x + 10;
            if (y + 10 > maxY) maxY = y + 10;
        }
        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                if (board[i][j] == 1)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
