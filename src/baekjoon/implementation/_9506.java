package baekjoon.implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class _9506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list;

        while (true) {
            int N = sc.nextInt();
            if (N == -1)
                break;
            int total = 0;
            list = new ArrayList<>();
            for (int i = 1; i < N; i++) {
                if (N % i == 0) {
                    list.add(i);
                    total += i;
                }
            }
            if (total == N) {
                System.out.print(N + " = ");
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        System.out.println(list.get(i));
                    } else {
                        System.out.print(list.get(i) + " + ");
                    }
                }
            } else {
                System.out.println(N + " is NOT perfect.");
            }
        }
    }
}
