package baekjoon.implementation;

import java.util.Scanner;

public class _9782 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseNum = 1;
        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            double median = findMedian(arr);
            System.out.printf("Case %d: %.1f\n", caseNum++, median);
        }

        sc.close();
    }

    public static double findMedian(int[] arr) {
        int n = arr.length;
        if (n % 2 != 0) {
            return (double) arr[(n + 1) / 2 - 1];
        } else {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        }
    }
}
