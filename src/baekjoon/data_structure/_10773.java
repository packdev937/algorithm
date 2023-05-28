package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _10773 {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0 && !dq.isEmpty()) {
                dq.pollFirst();
            } else dq.addFirst(num);
        }

        int total = 0;
        int len = dq.size();
        for (int i = 0; i < len; i++) {
            total += dq.pollFirst();
        }
        System.out.println(total);
    }
}
