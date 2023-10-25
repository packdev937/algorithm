package baekjoon.data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14235 {

    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            if (A == 0) {
                if (pq.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(pq.poll());
            }
            for (int j = 0; j < A; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
    }

}
