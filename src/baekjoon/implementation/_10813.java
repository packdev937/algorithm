package baekjoon.implementation;

import java.util.Scanner;

public class _10813 {
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
            int temp = arr[k - 1];
            arr[k - 1] = arr[l - 1];
            arr[l - 1] = temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
