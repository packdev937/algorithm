package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1715 {
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long total = 0;
        while (pq.size() > 1) {
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            total += (temp1 + temp2);
            pq.add(temp1 + temp2);
        }
        System.out.println(total);
    }
}

