package baekjoon.implementation;

import java.util.Scanner;

public class _25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = "";

        for (int i = 0; i < N / 4; i++) {
            str += "long ";
        }
        str += "int ";
        System.out.println(str);
    }
}
