package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _2164 {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            dq.addLast(i + 1);
        }

        while (dq.size() != 1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }
        System.out.println(dq.pollFirst());
    }
}
