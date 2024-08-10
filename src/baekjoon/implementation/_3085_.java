package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3085_ {

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        char[][] temp = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
	cloneArray(board, temp);
	swap(temp, i, j + 1, i, j);
	calculateMaxLength(temp);
	// 깊은 복사가 되버려 수동으로 복사해야 의도한 대로 매번 배열을 초기화 할 수 있다
//	temp = board.clone();
	// 혹은 다시 원상 복구
//	swap(board, i, j, i, j + 1); // 원상복구

	cloneArray(board, temp);
	swap(temp, j + 1, i, j, i);
	calculateMaxLength(temp);
            }
        }

        System.out.println(max);
    }

    private static void cloneArray(char[][] ori, char[][] temp) {
        for (int i = 0; i < ori.length; i++) {
            for (int j = 0; j < ori.length; j++) {
	temp[i][j] = ori[i][j];
            }
        }
    }

    // 계산 로직에 오류가 있었음
    private static void calculateMaxLength(char[][] board) {
        int N = board.length;

        for (int i = 0; i < N; i++) {
            int lengthX = 1;
            int lengthY = 1;

            for (int j = 1; j < N; j++) {
	// 행을 검사
	if (board[i][j] == board[i][j - 1]) {
	    lengthX++;
	} else {
	    max = Math.max(max, lengthX);
	    lengthX = 1;
	}

	// 열을 검사
	if (board[j][i] == board[j - 1][i]) {
	    lengthY++;
	} else {
	    max = Math.max(max, lengthY);
	    lengthY = 1;
	}
            }
            max = Math.max(max, Math.max(lengthX, lengthY));
        }
    }

    private static void swap(char[][] temp, int i, int j, int x, int y) {
        char tempChar = temp[i][j];
        temp[i][j] = temp[x][y];
        temp[x][y] = tempChar;
    }

}
