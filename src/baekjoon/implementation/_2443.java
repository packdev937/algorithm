package baekjoon.implementation;

import java.util.Scanner;

public class _2443 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * N - (2 * i) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
