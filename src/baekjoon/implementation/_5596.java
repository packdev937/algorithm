package baekjoon.implementation;

import java.util.Scanner;

public class _5596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total1 = 0;
        for (int i = 0; i < 4; i++) {
            total1 += sc.nextInt();
        }

        int total2 = 0;
        for (int i = 0; i < 4; i++) {
            total2 += sc.nextInt();
        }
        if (total1 > total2)
            System.out.println(total1);
        else System.out.println(total2);
    }
}
