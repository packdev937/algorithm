package baekjoon.string;

import java.util.Scanner;

public class _15813 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String name = sc.next();
        int answer = 0;

        for (int i = 0; i < name.length(); i++) {
            answer += (int) name.charAt(i) - 64;
        }

        System.out.println(answer);
    }

}
