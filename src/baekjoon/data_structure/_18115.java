package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        String[] commands = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(commands[N - 1 - i]);
            if (num == 1) {
                deque.addLast(i+1);
            } else if (num == 2) {
                int second = deque.removeLast();
                deque.addLast(i+1);
                deque.addLast(second);
            } else if (num == 3) {
                deque.addFirst(i+1);
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
