package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2605 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> temp = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number == 0) {
                queue.addLast(i);
            } else {
                while (number != 0) {
                    temp.addLast(queue.pollLast());
                    number--;
                }
                queue.addLast(i);
                while (!temp.isEmpty()) {
                    queue.addLast(temp.pollLast());
                }
            }
        }

        while(!queue.isEmpty()){
            sb.append(queue.pollFirst()+" ");
        }
        System.out.println(sb);
    }
}

// Queue
// Stack
// HashMap
// TreeSet