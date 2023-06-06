package baekjoon.brute_force;

import java.util.Scanner;

public class _19532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] var = new int[6];
        int x = 0, y = 0;
        for (int i = 0; i < var.length; i++) {
            var[i] = sc.nextInt();
        }

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (var[0] * i + var[1] * j == var[2] && var[3] * i + var[4] * j == var[5]) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
