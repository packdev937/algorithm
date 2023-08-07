package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, (l1, l2) -> l1[0] - l2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0)[1]);
        for (int i = 1; i < list.size(); i++) {
            if (pq.peek() <= list.get(i)[0]) {
                pq.poll();
            }
            pq.add(list.get(i)[1]);
        }
        System.out.println(pq.size());
    }
}
