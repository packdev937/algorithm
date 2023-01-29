package inflearn.two_point;

import java.util.Scanner;

public class _3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0, total = 0;
        for (int i = 0; i < K; i++) {
            max += arr[i];
            total += arr[i];
        }

        int lt = 0;
        for (int i = K; i < N; i++) {
            total -= arr[lt++];
            total += arr[i];

            if (total > max)
                max = total;
        }

        System.out.println(max);
    }
}
