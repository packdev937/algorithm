package baekjoon.implementation;

import java.util.Scanner;

public class _2441 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        for (int i = 0; i < N; i++)
            System.out.println(" ".repeat(N).substring(N - i) + "*".repeat(N).substring(i));
    }
}
