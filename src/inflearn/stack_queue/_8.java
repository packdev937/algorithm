package inflearn.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _8 {
    public static void main(String[] args) {
        Deque<Integer> q = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int temp = 0;

        for (int i = 0; i < N; i++) {
            q.addLast(sc.nextInt());
            if (i == M) {
                temp = q.getLast();
            }
        }

        boolean isMax = true;
        int cnt = 0;
        while (true) {
            int patient = q.removeFirst();
            for (int i = 0; i < q.size(); i++) {
                int wait = q.removeFirst();
                if (patient <= wait) {
                    q.addFirst(wait);
                    q.addLast(patient);
                    break;
                } else q.addLast(wait);
            }
            cnt++;
            if (patient == temp) {
                System.out.println(cnt);
                break;
            }
        }
    }
}
