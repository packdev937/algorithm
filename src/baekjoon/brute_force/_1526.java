package baekjoon.brute_force;

import java.util.Scanner;

public class _1526 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (true) {
            String s = String.valueOf(N);
            boolean isTrue = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '4' || s.charAt(i) == '7') {
                    continue;
                } else {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                System.out.println(s);
                break;
            } else {
                N--;
            }
        }
    }
}
