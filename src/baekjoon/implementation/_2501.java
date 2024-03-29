package baekjoon.implementation;

import java.util.Scanner;

public class _2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0)
                cnt++;
            if (cnt == K) {
                System.out.println(i);
                break;
            }
        }
        if (cnt < K)
            System.out.println(0);
    }
}
