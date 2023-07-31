package baekjoon.implementation;

import java.util.Scanner;

public class _1598 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int a1 = (N - 1) / 4;
        int a2 = (N - 1) % 4;
        int b1 = (M - 1) / 4;
        int b2 = (M - 1) % 4;

        System.out.print(Math.abs(a1 - b1) + Math.abs(a2 - b2));
    }

}
