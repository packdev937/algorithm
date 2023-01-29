package inflearn.array;

import java.util.Scanner;

public class _9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        int max = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // check row
        for (int i = 0; i < board.length; i++) {
            int sum = 0;
            for (int j = 0; j < board[i].length; j++) {
                sum += board[i][j];
            }
            if (sum > max)
                max = sum;
        }

        //check column
        for (int i = 0; i < board.length; i++) {
            int sum = 0;
            for (int j = 0; j < board[i].length; j++) {
                sum += board[j][i];
            }
            if (sum > max)
                max = sum;
        }

        //check diagonal
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum += board[i][i];
        }
        if (sum > max)
            max = sum;

        sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum += board[board.length - 1 - i][i];
        }
        if (sum > max)
            max = sum;

        System.out.println(max);
    }
}
