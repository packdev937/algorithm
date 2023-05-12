package baekjoon.implementation;

import java.util.Scanner;

public class _2490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("EABCD".charAt(4 - sc.nextLine().replaceAll(" ", "").replaceAll("0", "").length()));
        }
    }
}
