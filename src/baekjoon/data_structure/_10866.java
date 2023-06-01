package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _10866 {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "push_back":
                    dq.addLast(Integer.parseInt(s[1]));
                    break;
                case "push_front":
                    dq.addFirst(Integer.parseInt(s[1]));
                    break;
                case "front":
                    if (!dq.isEmpty())
                        sb.append(dq.peekFirst()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if (!dq.isEmpty())
                        sb.append(dq.peekLast()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "pop_back":
                    if (!dq.isEmpty())
                        sb.append(dq.pollLast()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "pop_front":
                    if (!dq.isEmpty())
                        sb.append(dq.pollFirst()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (!dq.isEmpty())
                        sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}