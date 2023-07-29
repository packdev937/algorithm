package baekjoon.implementation;

import java.util.Scanner;

public class _1284 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.next();
            if (str.equals("0")) {
                break;
            }
            int answer = 1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    answer += 3;
                } else if (str.charAt(i) == '0') {
                    answer += 5;
                } else {
                    answer += 4;
                }
            }

            System.out.println(answer);
        }
    }

}
