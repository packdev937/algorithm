package baekjoon.math;

import java.util.Scanner;

public class _1934 {

    public static int GCD(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        } else {
            return GCD(b, a % b);
        }
    }

    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(LCM(A, B));
        }
        sc.close();
    }
}