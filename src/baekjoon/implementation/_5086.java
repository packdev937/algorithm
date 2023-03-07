package baekjoon.implementation;

import java.util.Scanner;

public class _5086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            if (N == 0 && M == 0) break;
            else {
                if (N > M && N % M == 0) {
                    System.out.println("multiple");
                } else if (N < M && M % N == 0) {
                    System.out.println("factor");
                } else System.out.println("neither");
            }
        }
    }
}
