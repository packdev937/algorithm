package baekjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24460 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
	arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(divide_conquer(0, N - 1, 0, N - 1));
    }

    private static int divide_conquer(int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart == rowEnd && colStart == colEnd) {
            return arr[rowStart][colStart];
        } else {
            int rowMid = (rowStart + rowEnd) / 2;
            int colMid = (colStart + colEnd) / 2;

            int[] results = new int[4];
            results[0] = divide_conquer(rowStart, rowMid, colStart, colMid);
            results[1] = divide_conquer(rowStart, rowMid, colMid + 1, colEnd);
            results[2] = divide_conquer(rowMid + 1, rowEnd, colStart, colMid);
            results[3] = divide_conquer(rowMid + 1, rowEnd, colMid + 1, colEnd);

            Arrays.sort(results);
            return results[1];
        }
    }

}

