package baekjoon.implementation;

import java.util.Scanner;

public class _10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            int k = sc.nextInt();
            int l = sc.nextInt();
            int n = (l - (k - 1)) / 2;
            for (int j = 0; j < n; j++) {
                int temp = arr[k - 1 + j];
                arr[k - 1 + j] = arr[l - 1 - j];
                arr[l - 1 - j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
