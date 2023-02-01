package inflearn.data_structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class _5 {
    public static int Solution(int[] arr, int N, int K) {
        // 내림차순 정렬을 위한 reverseOrder();
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int l = j + 1; l < N; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : Tset) {
            cnt++;
            if (cnt == K) return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        _5 T = new _5();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.Solution(arr, N, K));
    }
}
