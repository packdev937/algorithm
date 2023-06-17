package baekjoon.implementation;

import java.util.Scanner;

public class _10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            if (num < 40)
                total += 40;
            else total += num;
        }
        System.out.println(total / 5);
    }
}
