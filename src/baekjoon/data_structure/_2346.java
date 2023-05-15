package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _2346 {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        // Initialization
        for (int i = 0; i < N; i++) {
            dq.addLast(i + 1);
        }

        int next, t;
        for (int i = 0; i < N; i++) {
            System.out.println(t = dq.pollFirst());
            if (i == N - 1)
                break;
            next = Integer.parseInt(s[t - 1]);
            if (next < 0) {
                for (int j = 0; j < Math.abs(next); j++) {
                    dq.addFirst(dq.pollLast());
                }
            } else {
                for (int j = 0; j < Math.abs(next)-1; j++) {
                    dq.addLast(dq.pollFirst());
                }
            }
        }
    }
}
