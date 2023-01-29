package inflearn.two_point;

import java.util.Arrays;
import java.util.Scanner;

public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] arr = new int[N > M ? N : M];
        // Sorting
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int lt = 0, rt = 0, pt = 0;
        while (true) {
            if (lt == N - 1) {
                if (arr1[lt] < arr2[rt] || rt == M - 1)
                    break;
                else {
                    rt++;
                }
                if (arr1[lt] == arr2[rt]) {
                    arr[pt] = arr1[lt];
                    break;
                }
            }

            if (rt == M - 1) {
                if (arr1[lt] > arr2[rt] || lt == N - 1)
                    break;
                else {
                    lt++;
                }
                if (arr1[lt] == arr2[rt]) {
                    arr[pt] = arr2[rt];
                    break;
                }
            }

            if (arr1[lt] == arr2[rt]) {
                arr[pt++] = arr1[lt];
                lt++;
                rt++;
            }

            if (arr1[lt] > arr2[rt])
                rt++;
            else if (arr1[lt] < arr2[rt])
                lt++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
