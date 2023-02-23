package baekjoon.implementation;

import java.util.Scanner;

public class _10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < M; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();
            int index = j-1;
            for (int m = 0; m < k - j + 1; m++) {
                arr[index++] = l;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}