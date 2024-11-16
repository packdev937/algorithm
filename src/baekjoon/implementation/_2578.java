package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _2578 {

    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];

        // 보드 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
	board[i][j] = Integer.parseInt(st.nextToken());
	map.put(board[i][j], new int[]{i, j});
            }
        }

        int count = 0;

        // 숫자 호출 처리
        loop:
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
	count++;
	int number = Integer.parseInt(st.nextToken());

	// 보드 업데이트
	int[] point = map.get(number);
	board[point[0]][point[1]] = 0;

	// 빙고 체크
	if (isBingo(board)) {
	    break loop;
	}
            }
        }

        System.out.println(count);
    }

    private static boolean isBingo(int[][] board) {
        int bingoCount = 0;

        // 가로, 세로 체크
        for (int i = 0; i < 5; i++) {
            int horizontalCount = 0;
            int verticalCount = 0;
            for (int j = 0; j < 5; j++) {
	if (board[i][j] == 0) horizontalCount++;
	if (board[j][i] == 0) verticalCount++;
            }
            if (horizontalCount == 5) bingoCount++;
            if (verticalCount == 5) bingoCount++;
        }

        // 대각선 체크
        int diagonalCount = 0;
        int reverseCount = 0;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] == 0) diagonalCount++;
            if (board[i][4 - i] == 0) reverseCount++;
        }
        if (diagonalCount == 5) bingoCount++;
        if (reverseCount == 5) bingoCount++;

        return bingoCount >= 3;
    }
}
