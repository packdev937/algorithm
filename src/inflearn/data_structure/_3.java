package inflearn.data_structure;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class _3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Integer [] arr = new Integer[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] cnt = new int[1000000];
        int unique = 0;
        for (int i = 0; i < K; i++) {
            if (cnt[arr[i]] == 0) unique++;
            cnt[arr[i]]++;
        }
        System.out.print(unique + " ");

        for (int i = K; i < N; i++) {
            cnt[arr[i-K]]--;
            if (cnt[arr[i-K]] == 0) unique--;
            if (cnt[arr[i]] == 0) unique++;
            cnt[arr[i]]++;
            System.out.print(unique + " ");
        }
    }
}