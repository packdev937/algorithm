package implementation;

import java.util.Scanner;

public class _2566 {
    private static int N = 9;
    private static int max = 0;
    private static int x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((x+1) + " " + (y+1));
    }
}
