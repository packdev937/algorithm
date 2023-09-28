package baekjoon.data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            while (!dq.isEmpty() && dq.getFirst() < i - L + 1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[dq.getLast()] > arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            sb.append(arr[dq.getFirst()]).append(' ');
        }
        System.out.println(sb);
    }
}
