package baekjoon.greedy;

import java.util.Scanner;

public class _5585 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] coin = new int[]{500, 100, 50, 10, 5, 1};

        N = 1000 - N;
        int cnt = 0;
        int idx = 0;
        while (N > 0) {
            cnt += N / coin[idx];
            N %= coin[idx++];
        }

        System.out.print(cnt);
    }

}
