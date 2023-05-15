package baekjoon.implementation;

import java.util.Scanner;

public class _1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = 1;
            for (int j = 1; j < b; j++) {
                r = (r * a) % 10;
            }
            if (r == 0)
                System.out.println(10);
            else System.out.println(r);
        }
    }
}
