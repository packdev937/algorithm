package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _18258 {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] s;

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            switch (s[0]) {
                case "push":
                    dq.addLast(Integer.parseInt(s[1]));
                    break;
                case "front":
                    if (dq.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(dq.peekFirst()).append("\n");
                    break;
                case "back":
                    if (dq.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(dq.peekLast()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty())
                        sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "pop":
                    if (dq.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(dq.pollFirst()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
