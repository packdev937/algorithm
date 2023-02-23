package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class _8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int left = 0, right = arr.length - 1, middle;
        int cnt = 0;

        while (true) {
            cnt++;
            middle = (left + right) / 2;
            if (arr[middle] == M)
                break;
            else {
                if (M > arr[middle]) {
                    left = middle;
                } else if (M < arr[middle]) {
                    right = middle;
                }
            }
        }
        System.out.println(middle+1);
    }
}
