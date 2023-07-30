package baekjoon.implementation;

import java.util.Scanner;

public class _1547 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ball = 1;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == ball) {
                ball = b;
            } else if (b == ball) {
                ball = a;
            }
        }
        System.out.print(ball);
    }

}
