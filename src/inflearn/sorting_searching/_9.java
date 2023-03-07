package inflearn.sorting_searching;

import java.util.Scanner;

public class _9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }

        int avg = arr[arr.length - 1] / M;

        int idx = 0, cnt = 0, max = 0;
        while (true) {
            if(cnt == M-1)
                break;
            if (arr[idx] > avg) {
                for (int i = idx; i < arr.length; i++) {
                    arr[i] -= arr[idx - 1];
                }
                if(arr[idx-1] > max)
                    max = arr[idx-1];
                cnt++;
                idx++;
            }
            else idx++;
        }
        System.out.print(max);
    }
}
