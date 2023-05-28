package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _10845 {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "push":
                    dq.addLast(Integer.parseInt(s[1]));
                    break;
                case "front":
                    if (!dq.isEmpty())
                        System.out.println(dq.peekFirst());
                    else System.out.println(-1);
                    break;
                case "back":
                    if (!dq.isEmpty())
                        System.out.println(dq.peekLast());
                    else System.out.println(-1);
                    break;
                case "pop":
                    if (!dq.isEmpty())
                        System.out.println(dq.pollFirst());
                    else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if (!dq.isEmpty())
                        System.out.println("0");
                    else System.out.println("1");
                    break;
            }
        }
    }
}
