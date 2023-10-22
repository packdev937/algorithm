package baekjoon.implementation;

import java.util.Scanner;

public class _2523 {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < Math.abs(N-1-i); j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
