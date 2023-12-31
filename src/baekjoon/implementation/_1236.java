package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
	if (input.charAt(j) == '.') {
	    board[i][j] = 0;
	    continue;
	}
	board[i][j] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
	if (board[i][j] == 0 && !checkRow(board, i, j) && !checkColumn(board, i, j)) {
	    board[i][j] = 1;
	    answer++;
	}
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
	if (board[i][j] == 0 && !checkRow(board, i, j)) {
	    board[i][j] = 1;
	    answer++;
	} else if (board[i][j] == 0 && !checkColumn(board, i, j)) {
	    board[i][j] = 1;
	    answer++;
	}
            }
        }
        System.out.println(answer);
    }

    public static boolean checkRow(int[][] board, int x, int y) {
        boolean isTrue = false;

        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == 1) {
	isTrue = true;
	break;
            }
        }

        return isTrue;
    }

    public static boolean checkColumn(int[][] board, int x, int y) {
        boolean isTrue = false;

        for (int i = 0; i < board[0].length; i++) {
            if (board[x][i] == 1) {
	isTrue = true;
	break;
            }
        }
        return isTrue;
    }
}
