package baekjoon.implementation;

import java.util.Scanner;

public class _2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < Math.abs(i - (N - 1)); j++) {
                System.out.print(" ");
            }
            if (i < N) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.print("*");
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
            }
            else if (i >= N) {
                for (int j = 0; j < (2*N-1) - i - 1; j++) {
                    System.out.print("*");
                }
                System.out.print("*");
                for (int j = 0; j < (2*N-1) - i - 1; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
