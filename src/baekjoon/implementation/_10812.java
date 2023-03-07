package baekjoon.implementation;

import java.util.Scanner;

public class _10812 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        int[] temp;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int l = 0; l < M; l++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            int t = i;
            temp = new int[j - i + 1];
            for (int m = 0; m < temp.length; m++) {
                if (k <= j) {
                    temp[m] = arr[k - 1];
                    k++;
                } else {
                    temp[m] = arr[i - 1];
                    i++;
                }
            }

            for (int m = 0; m < temp.length; m++) {
                arr[t - 1] = temp[m];
                t++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}