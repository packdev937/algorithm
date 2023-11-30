package baekjoon.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2239 {

    static final int BOARD_SIZE = 9;
    static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < BOARD_SIZE; i++) {
            String input = br.readLine();
            for (int j = 0; j < BOARD_SIZE; j++) {
	board[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        backtracking();

    }

    private static void backtracking() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
	if (board[i][j] == 0) {
	    for (int k = 1; k <= 9; k++) {
	        if (isAvaliableNumber(i, j, k)) {
	            board[i][j] = k;
	            backtracking();
	            board[i][j] = 0;
	        }
	    }
	    return; // 빈 칸에 숫자를 채우지 못하면 되돌아감
	}
            }
        }
        printBoard();
        System.exit(0); // 첫 번째 해를 찾으면 프로그램 종료
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
	System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isAvaliableNumber(int x, int y, int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (x == i) {
	continue;
            }
            if (board[i][y] == number) {
	return false;
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (y == i) {
	continue;
            }
            if (board[x][i] == number) {
	return false;
            }
        }
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
	if (board[i][j] == number) {
	    return false;
	}
            }
        }

        return true;
    }
}
