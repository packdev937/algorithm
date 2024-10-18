package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4396 {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        char[][] open = new char[N][N];

        for (int i = 0; i < board.length; i++) {
            String input = br.readLine();
            for (int j = 0; j < board[i].length; j++) {
	board[i][j] = input.charAt(j) == '*' ? -1 : 0;
            }
        }

        boolean isBoom = false;
        for (int i = 0; i < open.length; i++) {
            String input = br.readLine();
            for (int j = 0; j < open[i].length; j++) {
	if (input.charAt(j) == 'x') {
	    open[i][j] = countMines(board, i, j);
	    if (board[i][j] == -1) {
	        isBoom = true;
	    }
	} else {
	    open[i][j] = '.';
	}
            }
        }

        for (int i = 0; i < open.length; i++) {
            for (int j = 0; j < open[i].length; j++) {
	if(isBoom && board[i][j] == -1){
	    open[i][j] = '*';
	}
	System.out.print(open[i][j]);
            }
            System.out.println();
        }
    }

    public static char countMines(int[][] board, int i, int j) {
        int count = 0;

        for (int k = 0; k < dx.length; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[nx].length
	&& board[nx][ny] == -1) {
	count++;
            }
        }

        return (char) (count + '0');
    }

}
