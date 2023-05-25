package baekjoon.data_structure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _17608 {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (dq.isEmpty())
                dq.addLast(num);
            else {
                while (!dq.isEmpty() && dq.peekLast() <= num)
                    dq.pollLast();
                dq.addLast(num);
            }
        }
        System.out.println(dq.size());
    }
}
