package baekjoon.string;

import java.util.Scanner;

public class _25372 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            if (str.length() >= 6 && str.length() <= 9) {
                sb.append("yes\n");
            } else sb.append("no\n");
        }
        System.out.println(sb);
    }
}
